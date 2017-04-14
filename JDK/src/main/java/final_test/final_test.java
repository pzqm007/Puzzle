package final_test;

public final class final_test {
	private final int i=0;
	private static final int j=1;
	
	private static final void nothing(){
		
	}
	
	private final void aha(){
		final int i=0;
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(i);
			}
		});
		
	}
	
	private final void alala(final int i){
		
	}
	
	
	
}
