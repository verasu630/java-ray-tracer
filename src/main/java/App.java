import com.ibm.vera.raytracer.entities.Environment;
import com.ibm.vera.raytracer.entities.Point;
import com.ibm.vera.raytracer.entities.Projectile;
import com.ibm.vera.raytracer.entities.Tuple;
import com.ibm.vera.raytracer.entities.Vector;

public class App {

	public static void main(String[] args) {
		
		System.out.println("Launching...");

		Projectile proj = new Projectile(new Point(0, 1, 0), Tuple.normalise(new Vector(1, 1, 0)));
		Environment env = new Environment(new Vector(0, -0.1, 0), new Vector(-0.01, 0, 0));

		System.out.println(proj.toString());
		System.out.println(env.toString());
		
		while(proj.position().getY() > 0) {
			System.out.println(proj.position().toString());
			proj = tick(env, proj);
		}
		

		System.out.println("Finished launching, final position is " + proj.position().toString());
		
	}
	
	private static Projectile tick(Environment env, Projectile proj) {
		Tuple pos = Tuple.add(proj.position(), proj.velocity());
		Tuple vel = Tuple.add(Tuple.add(proj.velocity(), env.gravity()), env.wind());
		
		Projectile result = new Projectile(pos, vel);
		return result;
		
	}

}
