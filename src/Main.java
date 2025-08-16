import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws Exception {

        var usuario = "vinicius";
        var senha = "1234";

        //Criação da janela
        JFrame janela = new JFrame();
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setBounds(470, 200, 800, 600);
        janela.getContentPane().setBackground(Color.BLACK);
        janela.setLayout(null);
        janela.setVisible(true);



        //Titulo
        JLabel labelTitulo = new JLabel("Login");
        labelTitulo.setBounds(320, 140, 900, 100);
        labelTitulo.setForeground(Color.white);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 30));
        janela.add(labelTitulo);

        //criação da caixa de usuario
        JLabel labelUsuario = new JLabel("Usuario ");
        labelUsuario.setBounds(300, 220, 150, 30);
        labelUsuario.setForeground(Color.WHITE);
        janela.add(labelUsuario);

        JTextField campoUsuario = new JTextField();
        campoUsuario.setBounds(300, 250, 150, 30);
        janela.add(campoUsuario);

        // Criação da caixa senha
        JLabel labelSenha = new JLabel("Senha ");
        labelSenha.setBounds(300, 280, 150, 30);
        labelSenha.setForeground(Color.WHITE);
        janela.add(labelSenha);

        JPasswordField campoSenha = new JPasswordField();
        campoSenha.setBounds(300, 310, 150, 30);
        janela.add(campoSenha);

        //Criação do botao
        JButton botaoLogin = new JButton("Login");
        janela.add(botaoLogin);
        botaoLogin.setBounds(340, 360, 70, 30);
        botaoLogin.setBackground(Color.WHITE);
        botaoLogin.setForeground(Color.BLACK);
        botaoLogin.setFocusPainted(false);
        botaoLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = campoUsuario.getText();
                String password = new String(campoSenha.getPassword());

                if (usuario.equals(user) && senha.equals(password)) {
                    JOptionPane.showMessageDialog(null, "Login efetuado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos!");
                }
                campoUsuario.setText("");// limpa os campos
                campoSenha.setText("");// limpa os campos

                janela.dispose();//Fecha a janela


                //segunda Janela
                JFrame janela2 = new JFrame();
                janela2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                janela2.setBounds(470, 200, 1200, 700);
                janela2.getContentPane().setBackground(Color.BLACK);
                janela2.setVisible(true);
                janela2.setLayout(new BorderLayout());

                // Painel lateral (menu)
                JPanel sidebar = new JPanel();
                sidebar.setBackground(new Color(30, 30, 30)); // cinza escuro
                sidebar.setPreferredSize(new Dimension(250, 650)); // largura fixa
                sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));

                // Título
                JLabel titulo = new JLabel("Gêneros");
                titulo.setForeground(Color.WHITE);
                titulo.setFont(new Font("Arial", Font.BOLD, 19));
                titulo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                sidebar.add(titulo);

                // Painel central
                JPanel conteudo = new JPanel();
                conteudo.setLayout(new GridLayout(0, 3, 15, 15));
                conteudo.setBackground(Color.BLACK);
                JScrollPane scroll = new JScrollPane(conteudo);
                scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

                janela2.add(sidebar, BorderLayout.WEST);
                janela2.add(scroll, BorderLayout.CENTER);

                // Botões de gênero
                String[] generos = {"Ação", "Comédia", "Drama", "Terror", "Romance", "Ficção Científica", "Animação"};
                int[] ids = {28, 35, 18, 27, 10749, 878, 16};

                for (int i = 0; i < generos.length; i++) {
                    String genero = generos[i];
                    int genreId = ids[i];

                    JButton botao = new JButton(genero);
                    botao.setMaximumSize(new Dimension(190, 50));
                    botao.setAlignmentX(Component.LEFT_ALIGNMENT);
                    botao.setBackground(new Color(45, 45, 45));
                    botao.setForeground(Color.WHITE);
                    botao.setFocusPainted(false);
                    sidebar.add(botao);
                    sidebar.add(Box.createVerticalStrut(5));

                    // Aqui chamamos a API
                    botao.addActionListener(ev -> mostrarFilmes(conteudo, genreId));
                }
            }

            private static void mostrarFilmes(JPanel painel, int genreId) {
                painel.removeAll();

                SwingWorker<Void, Void> worker = new SwingWorker<>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        try {
                            // Substitua TMDbAPI.getMoviesByGenre(genreId) pelo seu método real
                            JsonArray filmes = MovieBrowser.getMoviesByGenre(genreId);

                            for (int i = 0; i < filmes.size(); i++) {
                                JsonObject filme = filmes.get(i).getAsJsonObject();
                                String titulo = filme.get("title").getAsString();
                                String posterPath = filme.get("poster_path").getAsString();

                                BufferedImage image = ImageIO.read(new URL("https://image.tmdb.org/t/p/w200" + posterPath));
                                ImageIcon icon = new ImageIcon(image);

                                JLabel label = new JLabel(titulo, icon, JLabel.CENTER);
                                label.setVerticalTextPosition(JLabel.BOTTOM);
                                label.setHorizontalTextPosition(JLabel.CENTER);
                                label.setForeground(Color.WHITE);

                                painel.add(label);
                            }

                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                        return null;
                    }

                    @Override
                    protected void done() {
                        painel.revalidate();
                        painel.repaint();
                    }
                };

                worker.execute();
            }
        });
    }
}

