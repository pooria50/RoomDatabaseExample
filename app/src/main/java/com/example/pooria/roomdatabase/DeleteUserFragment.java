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
public class DeleteUserFragment extends Fragment {
    private EditText id;
    private Button update;

    public DeleteUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete_user, container, false);
        id = view.findViewById(R.id.edt_id);
        update = view.findViewById(R.id.btn_save);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int user_id = Integer.parseInt(id.getText().toString());
                User user = new User();
                user.setId(user_id);
                MainActivity.myAppDatabase.myDao().deleteUser(user);
                Toast.makeText(getActivity(), "User Deleted", Toast.LENGTH_SHORT).show();
                id.setText("");
            }
        });
        return view;
    }

}
