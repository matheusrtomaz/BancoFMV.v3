package com.example.bancofmv

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast // Adicionada esta linha para importar a classe Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home) // Define o layout para a HomeActivity

        // Configura os insets da janela para lidar com as barras do sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.home_main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Referências aos novos elementos do layout
        val profileImageView = findViewById<ImageView>(R.id.profileImageView)
        val userNameTextView = findViewById<TextView>(R.id.userNameTextView)
        val accountIdTextView = findViewById<TextView>(R.id.accountIdTextView)
        val balanceTextView = findViewById<TextView>(R.id.balanceTextView)
        val pixButton = findViewById<Button>(R.id.pixButton)
        val statementButton = findViewById<Button>(R.id.statementButton)
        val logoutButton = findViewById<Button>(R.id.logoutButton) // Antigo backToMainButton

        // Configura os textos iniciais (já definidos no XML, mas pode ser dinâmico aqui)
        userNameTextView.text = "Matheus Rodrigues Tomaz"
        accountIdTextView.text = "ID: 01706850"
        balanceTextView.text = "R$ 1.543,21" // Você pode buscar esse valor de forma dinâmica

        // Lógica para o botão Pix (exemplo)
        pixButton.setOnClickListener {
            Toast.makeText(this, "Área Pix (em desenvolvimento)", Toast.LENGTH_SHORT).show()
            // TODO: Implementar navegação para a tela Pix
        }

        // Lógica para o botão Extrato (exemplo)
        statementButton.setOnClickListener {
            Toast.makeText(this, "Extrato (em desenvolvimento)", Toast.LENGTH_SHORT).show()
            // TODO: Implementar navegação para a tela de Extrato
        }

        // Lógica para o botão Sair
        logoutButton.setOnClickListener {
            // Cria um Intent para voltar para a tela principal (MainActivity)
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK // Limpa o back stack
            startActivity(intent)
            finish() // Finaliza esta Activity
        }
    }
}
