package g313.martin.lab13;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txt_a;
    EditText txt_b;
    TextView txt_res;
    Switch rad_deg;

    String url = "https://grandplay05.pythonanywhere.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_a = findViewById(R.id.txt_a);
        txt_b = findViewById(R.id.txt_b);
        txt_res = findViewById(R.id.txt_res);
        rad_deg = findViewById(R.id.sw_rad_deg);
    }

    public void on_btn_click(View v)
    {
        String btn_id = getResources().getResourceName(v.getId()).replace("g313.martin.lab13:id/", "");
        String a = txt_a.getText().toString();
        String b = txt_b.getText().toString();
        HttpRequest r = new HttpRequest(this)
        {
            @Override
            public void on_request_complete(String response)
            {
                Log.e("RESULT", response);
                txt_res.setText(response);
            }
        };

        Toast toast_error = Toast.makeText(this, "Error: Wrong input data", Toast.LENGTH_LONG);

        double x = Double.parseDouble(a);
        if (rad_deg.isChecked()) {
            x = Float.parseFloat(a) * (Math.PI / 180);
        }

        switch (btn_id)
        {
            case "btn_add":
                if (a.equals("") || b.equals(""))
            {
                toast_error.show();
                return;
            }
                r.make_request(url + "add/" + a + "/" + b);
                break;
            case "btn_sub":
                if (a.equals("") || b.equals(""))
                {
                    toast_error.show();
                    return;
                }
                r.make_request(url + "sub/" + a + "/" + b);
                break;
            case "btn_mul":
                if (a.equals("") || b.equals(""))
                {
                    toast_error.show();
                    return;
                }
                r.make_request(url + "mul/" + a + "/" + b);
                break;
            case "btn_div":
                if (a.equals("") || b.equals(""))
                {
                    toast_error.show();
                    return;
                }
                r.make_request(url + "div/" + a + "/" + b);
                break;
            case "btn_pow":
                if (a.equals("") || b.equals(""))
                {
                    toast_error.show();
                    return;
                }
                r.make_request(url + "pow/" + a + "/" + b);
                break;
            case "btn_sqrt":
                if (a.equals(""))
                {
                    toast_error.show();
                    return;
                }
                r.make_request(url + "sqrt/" + a);
                break;
            case "btn_sin":

                if (a.equals(""))
                {
                    toast_error.show();
                    return;
                }
                r.make_request(url + "sin/" + x);
                break;
            case "btn_cos":
                if (a.equals(""))
                {
                    toast_error.show();
                    return;
                }
                r.make_request(url + "cos/" + x);
                break;
            case "btn_tan":
                if (a.equals(""))
                {
                    toast_error.show();
                    return;
                }
                r.make_request(url + "tan/" + x);
                break;
        }
    }


}