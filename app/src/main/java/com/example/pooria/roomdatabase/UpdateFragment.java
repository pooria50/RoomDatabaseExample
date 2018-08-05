package com.example.pooria.roomdatabase;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class UpdateFragment extends Fragment {

    private EditText name,family,email,id;
    private Button update;
    public UpdateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update, container, false);
        id = view.findViewById(R.id.id);
        name = view.findViewById(R.id.name);
        family = view.findViewById(R.id.family);
        email = view.findViewById(R.id.email);
        update = view.findViewById(R.id.update);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer user_id = Integer.valueOf(id.getText().toString());
                String user_name = name.getText().toString();
                String user_family = family.getText().toString();
                String user_email = email.getText().toString();

                User user = new User();
                user.setId(user_id);
                user.setName(user_name);
                user.setFamily(user_family);
                user.setEmail(user_email);

                MainActivity.myAppDatabase.myDao().updateUser(user);
                Toast.makeText(getActivity(), "User Uploaded ...", Toast.LENGTH_SHORT).show();
                id.setText("");
                name.setText("");
                family.setText("");
                email.setText("");
            }
        });
        return view;
    }

}
