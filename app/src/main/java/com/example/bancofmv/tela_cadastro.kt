package com.example.bancofmv

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent


class tela_cadastro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tela_cadastro) // Define o layout da tela de cadastro

        // Configura os insets da janela para lidar com as barras do sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Referências aos elementos do layout
        val nameEditText = findViewById<EditText>(R.id.nameEditText)
        val emailCadastroEditText = findViewById<EditText>(R.id.emailCadastroEditText)
        val passwordCadastroEditText = findViewById<EditText>(R.id.passwordCadastroEditText)
        val confirmPasswordEditText = findViewById<EditText>(R.id.confirmPasswordEditText)
        val bt_cadastrar = findViewById<Button>(R.id.bt_cadastrar)

        // Ação para o botão de Finalizar Cadastro
        bt_cadastrar.setOnClickListener {
            val name = nameEditText.text.toString().trim()
            val email = emailCadastroEditText.text.toString().trim()
            val password = passwordCadastroEditText.text.toString().trim()
            val confirmPassword = confirmPasswordEditText.text.toString().trim()

            // Validações básicas
            if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show()
            } else if (password != confirmPassword) {
                Toast.makeText(this, "As senhas não coincidem.", Toast.LENGTH_SHORT).show()
            } else if (password.length < 6) { // Exemplo de validação de senha
                Toast.makeText(this, "A senha deve ter pelo menos 6 caracteres.", Toast.LENGTH_SHORT).show()
            }
            else {
                // TODO: Implementar a lógica de registro real aqui (Firebase, API, banco de dados local, etc.)
                // Por enquanto, apenas simula um cadastro bem-sucedido
                Toast.makeText(this, "Cadastro realizado com sucesso para: $email", Toast.LENGTH_LONG).show()

                // Navega para a tela Home após o cadastro bem-sucedido
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish() // Finaliza esta Activity para que o usuário não volte a ela pelo botão Voltar
            }
        }
    }
}
