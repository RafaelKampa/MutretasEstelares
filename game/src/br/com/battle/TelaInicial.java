package br.com.battle;

import br.pucpr.jge.GameFrame;
import br.pucpr.jge.InputManager;
import br.pucpr.jge.Steps;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import static java.awt.event.KeyEvent.VK_ESCAPE;
import static java.awt.event.KeyEvent.VK_SPACE;

public class TelaInicial implements Steps{

	@Override
	public void load() {
	}

	@Override
	public boolean update(double s, InputManager keys) {
		if (keys.isDown(VK_SPACE)) {
			EventQueue.invokeLater(() -> new GameFrame("Star Battle", 800, 650, new StarBattle()).setVisible(true));
			return false;
		}
		if (keys.isDown(VK_ESCAPE)) {
			return false;
		}
		return true;
	}

    @Override
    public void draw(Graphics2D g2d) throws FontFormatException, IOException {
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, 800, 650);
		Font font = Font.createFont(Font.TRUETYPE_FONT, new File("src/br/com/battle/PressStart2P.ttf"));
		var tituloFont = font.deriveFont(Font.PLAIN, 30f);
		g2d.setFont(tituloFont);

		Color startColor = Color.CYAN;
		Color endColor = Color.RED;
		GradientPaint gradient = new GradientPaint(250, 280, startColor, 500, 300, endColor);
		g2d.setPaint(gradient);
		g2d.drawString("MUTRETAS ESTELARES", 130, 300);


		var continuarFont = font.deriveFont(Font.PLAIN, 15f);
		g2d.setFont(continuarFont);
		Color startColor2 = Color.RED;
		Color endColor2 = Color.CYAN;
		GradientPaint gradient2 = new GradientPaint(300, 300, startColor2, 500, 400, endColor2);
		g2d.setPaint(gradient2);
		g2d.drawString("Pressione ESPA�O ou ESC para continuar", 115, 400);

		var rodapeFont = font.deriveFont(Font.PLAIN, 10f);
		g2d.setFont(rodapeFont);
		g2d.setColor(Color.GRAY);
		g2d.drawString("Desenvolvido por: Lucas Pego de Souza e Rafael Gilberto Kampa", 100, 630);
    }
    
	@Override
	public void draw2(Graphics2D g2d) throws FontFormatException, IOException {
	}

	@Override
	public void unload() {
	}
}