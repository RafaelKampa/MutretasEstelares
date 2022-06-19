package br.com.battle;

import java.util.Random;

import br.pucpr.jge.AbstractGameObject;
import br.pucpr.jge.GameManager;
import br.pucpr.jge.GameObject;
import br.pucpr.jge.InputManager;

public class Boss extends GameObject{
	private double initialX;
	private double t;
	private boolean isAlive = true;
	public double shotInterval = 0.5;
	public int cont;
	public int life = 10;

	public Boss(double x, double y) {
		super("/image/DeathStar.png", x, y);
		this.initialX = x;
	}
	

	public void update(double s, InputManager keys) {
		x = initialX + Math.sin(t) * 50;
		t += s;
		var alienShot = new AlienShot(getX() + 108, getY() + 88);
		cont ++;
		if (cont >= 0) {
			Random random = new Random();
			var rdn = random.nextInt(100);
			if (rdn == 10) {
				GameManager.getInstance().add(alienShot);
				cont = 0;
			}
		}
		var alienShot2 = new AlienShot(getX() + 20, getY() + 150);
		cont ++;
		if (cont >= 0) {
			Random random = new Random();
			var rdn = random.nextInt(100);
			if (rdn == 10) {
				GameManager.getInstance().add(alienShot2);
				cont = 0;
			}
		}
		var alienShot3 = new AlienShot(getX() + 280, getY() + 150);
		cont ++;
		if (cont >= 0) {
			Random random = new Random();
			var rdn = random.nextInt(100);
			if (rdn == 10) {
				GameManager.getInstance().add(alienShot3);
				cont = 0;
			}
		}
		var alienShot4 = new AlienShot(getX() + 150, getY() + 280);
		cont ++;
		if (cont >= 0) {
			Random random = new Random();
			var rdn = random.nextInt(100);
			if (rdn == 10) {
				GameManager.getInstance().add(alienShot4);
				cont = 0;
			}
		}
	}
	

	@Override
	public boolean isInGame() {
		return isAlive;
	}
	
	@Override
	public void onCollision(AbstractGameObject obj) {
		if (obj instanceof Shot) {
			this.life = this.life - 1;
			if (this.life == 0) {
				isAlive = false;
				GameManager.getInstance().add(new Explosion(this.getX() + 150, this.getY() + 150 ));
			}
		}
		if (obj instanceof Ship) {
			this.life = this.life - 1;
			if (this.life == 0) {
				isAlive = false;
				GameManager.getInstance().add(new Explosion(this.getX() + 150, this.getY() + 150 ));
			}
		}
	}
}