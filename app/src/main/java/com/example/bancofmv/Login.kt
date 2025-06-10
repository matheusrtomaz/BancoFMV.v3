package com.example.bancofmv

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast // Para exibir mensagens curtas
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login) // Define o layout para a LoginActivity

        // Configura os insets da janela para lidar com as barras do sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.login_main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Referências aos elementos do layout
        val emailEditText = findViewById<EditText>(R.id.emailEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val loginButton = findViewById<Button>(R.id.loginButton)
        val registerLink = findViewById<TextView>(R.id.registerLink)

        // Ação para o botão de Login
        loginButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show()
            } else {
                // TODO: Aqui você implementaria a lógica de autenticação real (Firebase, API, etc.)
                // Por enquanto, apenas para demonstração, vamos simular um login bem-sucedido
                if (email == "testemobile@email.com" && password == "123456") {
                    Toast.makeText(this, "Login bem-sucedido!", Toast.LENGTH_SHORT).show()
                    // Navega para a tela Home após o login
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                    finish() // Finaliza a LoginActivity para que o usuário não volte a ela pelo botão Voltar
                } else {
                    Toast.makeText(this, "Credenciais inválidas.", Toast.LENGTH_SHORT).show()
                }
            }
        }

        // Ação para o link de Cadastro
        registerLink.setOnClickListener {
            // Navega para a tela_cadastro quando o link é clicado
            val intent = Intent(this, tela_cadastro::class.java)
            startActivity(intent)
        }
    }
}
