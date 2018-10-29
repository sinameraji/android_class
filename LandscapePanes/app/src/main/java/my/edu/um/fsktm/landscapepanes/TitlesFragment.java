package my.edu.um.fsktm.landscapepanes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TitlesFragment extends ListFragment {

    boolean mDualPane;
    int mCurCheckPosition = 0;

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        //populate the list with our static array of titles
        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_activated_1, Shakespeare.TITLES));

        //check to see if we have frame in which to embed the details fragment
        //directly in the containing UI

        View detailsFrame = getActivity().findViewById(R.id.details);
        mDualPane = detailsFrame != null && detailsFrame.getVisibility() == View.VISIBLE;

        if (savedInstanceState != null) {
            //restore last state for checked position
            mCurCheckPosition = savedInstanceState.getInt("ourChoice", 0);
        }

        if(mDualPane){
            //in dual pane mode, the list view highlights the selected item.
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            //make sure our UI is in correct state
            showDetails(mCurCheckPosition);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("ourChoice", mCurCheckPosition);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        showDetails(position);
    }


    void showDetails(int index){
        mCurCheckPosition = index;
        if(mDualPane){
            //we can display everything in-place with fragments,
            //so update the list to highlight the selected item and show the data
            getListView().setItemChecked(index, true);
            //check what fragment is currently shown, replace if needed

            DetailsFragment details = (DetailsFragment)getActivity().getSupportFragmentManager().findFragmentById(R.id.details);

            if (details == null ||  details.getShownIndex() != index){
                //make new fragments to show this selection
                details = DetailsFragment.newInstance(index);
                //execute a transaction, replacing any existing fragment
                //with this one inside the frame.
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();

                if (index == 0){
                    ft.add(R.id.details, details);
                } else {
                    ft.replace(R.id.details, details);
                }
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            }
        } else{
            //else we need to launch new activity to display
            //the dialog fragment with selected text
            Intent intent = new Intent();
            intent.setClass(getActivity(),DetailsActivity.class);
            intent.putExtra("index",index);
            startActivity(intent);
        }
    }
}
