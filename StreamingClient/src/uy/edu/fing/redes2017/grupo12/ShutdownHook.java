package uy.edu.fing.redes2017.grupo12;

public class ShutdownHook {

	InterfazClientePrincipal f;
public ShutdownHook(InterfazClientePrincipal frame) {
		// TODO Auto-generated constructor stub
	f=frame;
	}

public void attachShutDownHook() {
	
	
	Runtime.getRuntime().addShutdownHook(new Thread() {
        @Override
        public void run() {
        f.fin();
            System.out.println("exit ......");
        }
    });

}



}