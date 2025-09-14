package com.example.phoneshopapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity {

  private TextInputLayout fullNameLayout, emailLayout, phoneLayout, passwordLayout, confirmPasswordLayout;
  private MaterialButton registerButton;
  private LinearLayout googleButton, facebookButton;
  private TextView loginLink;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_register);

    // Hide ActionBar
    if (getSupportActionBar() != null) {
      getSupportActionBar().hide();
    }

    // Initialize views
    fullNameLayout = findViewById(R.id.fullNameLayout);
    emailLayout = findViewById(R.id.emailLayout);
    phoneLayout = findViewById(R.id.phoneLayout);
    passwordLayout = findViewById(R.id.passwordLayout);
    confirmPasswordLayout = findViewById(R.id.confirmPasswordLayout);
    registerButton = findViewById(R.id.registerButton);
    googleButton = findViewById(R.id.googleButton);
    facebookButton = findViewById(R.id.facebookButton);
    loginLink = findViewById(R.id.loginLink);

    // Set click listeners
    registerButton.setOnClickListener(v -> {
      if (validateInputs()) {
        // Proceed with registration
        Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show();
        // Navigate to login or main activity
        // Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
        // startActivity(intent);
        // finish();
      }
    });

    googleButton.setOnClickListener(v -> {
      Toast.makeText(this, "Google registration clicked", Toast.LENGTH_SHORT).show();
    });

    facebookButton.setOnClickListener(v -> {
      Toast.makeText(this, "Facebook registration clicked", Toast.LENGTH_SHORT).show();
    });

    // Set click listener for login link
    loginLink.setOnClickListener(v -> {
      // Navigate back to login
      Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
      startActivity(intent);
      finish(); // Close the register activity
    });
  }

  private boolean validateInputs() {
    boolean isValid = true;

    // Validate full name
    if (fullNameLayout.getEditText().getText().toString().trim().isEmpty()) {
      fullNameLayout.setError("Full name is required");
      isValid = false;
    } else {
      fullNameLayout.setError(null);
    }

    // Validate email
    String email = emailLayout.getEditText().getText().toString().trim();
    if (email.isEmpty()) {
      emailLayout.setError("Email is required");
      isValid = false;
    } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
      emailLayout.setError("Enter a valid email address");
      isValid = false;
    } else {
      emailLayout.setError(null);
    }

    // Validate phone
    String phone = phoneLayout.getEditText().getText().toString().trim();
    if (phone.isEmpty()) {
      phoneLayout.setError("Phone number is required");
      isValid = false;
    } else {
      phoneLayout.setError(null);
    }

    // Validate password
    String password = passwordLayout.getEditText().getText().toString();
    if (password.isEmpty()) {
      passwordLayout.setError("Password is required");
      isValid = false;
    } else if (password.length() < 6) {
      passwordLayout.setError("Password must be at least 6 characters");
      isValid = false;
    } else {
      passwordLayout.setError(null);
    }

    // Validate confirm password
    String confirmPassword = confirmPasswordLayout.getEditText().getText().toString();
    if (confirmPassword.isEmpty()) {
      confirmPasswordLayout.setError("Please confirm your password");
      isValid = false;
    } else if (!confirmPassword.equals(password)) {
      confirmPasswordLayout.setError("Passwords do not match");
      isValid = false;
    } else {
      confirmPasswordLayout.setError(null);
    }

    return isValid;
  }
}
