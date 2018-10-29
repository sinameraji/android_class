package my.edu.um.fsktm.week6_fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentRabbit extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_harambe, container, false);
        TextView TVPenguin= (TextView)view.findViewById(R.id.TVPenguin);
        TVPenguin.setText("Harambe");
        return view;
    }

}
