package com.example.bancofmv

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main) // Define o layout da MainActivity

        // Configura a visibilidade das barras do sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Encontra o botão "Cadastrar" e define seu OnClickListener
        val botaoCadastrar = findViewById<Button>(R.id.bt_cadastrar)
        botaoCadastrar.setOnClickListener {
            // Cria um Intent para navegar para a tela_cadastro
            val intent = Intent(this, tela_cadastro::class.java)
            startActivity(intent)
        }

        // Encontra o botão "Entrar" e define seu OnClickListener
        val botaoEntrar = findViewById<Button>(R.id.entrar)
        botaoEntrar.setOnClickListener {
            // *** AGORA NAVEGANDO PARA A NOVA LOGINACTIVITY ***
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
