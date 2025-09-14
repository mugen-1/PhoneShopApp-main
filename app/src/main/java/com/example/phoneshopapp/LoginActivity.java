package com.example.phoneshopapp;

import androidx.appcompat.app.AppCompatActivity;
import com.example.phoneshopapp.HomeActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;



public class LoginActivity extends AppCompatActivity {

  EditText emailLayout, passwordLayout;
  Button loginButton, btnGoRegister;
  TextView registerLink;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);

    // Ánh xạ view
    emailLayout = findViewById(R.id.emailLayout);
    passwordLayout = findViewById(R.id.passwordLayout);
    loginButton = findViewById(R.id.loginButton);
    registerLink = findViewById(R.id.registerLink);


    // Chuyển sang RegisterActivity
    registerLink.setOnClickListener(v -> {
      Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
      startActivity(intent);
    });

    // Xử lý nút LOGIN
    loginButton.setOnClickListener(v -> {
      String email = emailLayout.getText().toString().trim();
      String password = passwordLayout.getText().toString().trim();

      if (password.equals("123456")) {
        // Đăng nhập thành công -> sang HomeActivity
        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
        intent.putExtra("trungtruc", email); // gửi dữ liệu
        startActivity(intent);
        finish(); // Đóng LoginActivity
      } else {
        // Sai mật khẩu
        Toast.makeText(LoginActivity.this, "Sai tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
      }
    });

    // Nút chuyển sang RegisterActivity
    btnGoRegister.setOnClickListener(v -> {
      Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
      startActivity(intent);
    });
  }
}
