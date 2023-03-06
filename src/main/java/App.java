import java.io.FileWriter;
import java.io.IOException;

import com.ibm.vera.raytracer.entities.Canvas;
import com.ibm.vera.raytracer.entities.Colour;
import com.ibm.vera.raytracer.entities.Environment;
import com.ibm.vera.raytracer.entities.Point;
import com.ibm.vera.raytracer.entities.Projectile;
import com.ibm.vera.raytracer.entities.Tuple;
import com.ibm.vera.raytracer.entities.Vector;

public class App {

	public static void main(String[] args) {
		
		Point start = new Point(0, 1, 0);
		Tuple velocity = Tuple.multiply(Tuple.normalise(new Vector(1, 1.8, 0)), 11.25);
		Projectile proj = new Projectile(start, velocity);
		
		Vector gravity = new Vector(0, -0.1, 0);
		Vector wind = new Vector(-0.01, 0, 0);
		Environment env = new Environment(gravity, wind);

		Canvas c = new Canvas(900, 550);
		
		while(proj.position().getY() > 0) {
			System.out.println(proj.position().toString());
			proj = tick(env, proj);
			
			c.writePixel((int) Math.round(proj.position().getX()), (int) Math.round(550-proj.position().getY()), new Colour(1, 1, 1));
		}
		
		System.out.println("Saving");
		saveToPPM(c.toPPM());

	}
	
	private static Projectile tick(Environment env, Projectile proj) {
		Tuple pos = Tuple.add(proj.position(), proj.velocity());
		Tuple vel = Tuple.add(Tuple.add(proj.velocity(), env.gravity()), env.wind());
		
		Projectile result = new Projectile(pos, vel);
		return result;
		
	}
	
	private static void saveToPPM(String str) {
		try {
			FileWriter write = new FileWriter("./artefacts/projectile.ppm");
			write.write(str);
			write.close();
			System.out.println("Written successfully");
		} catch (IOException e) {
			System.out.println("An error occurred");
			e.printStackTrace();
		}
	}

}
