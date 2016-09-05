package station;

import java.util.ArrayList;
import user.User;

public class SeviceFIFO {
	
	
	public int time;
	
	Clerk clerk1 = new Clerk();
	Clerk clerk2 = new Clerk();
	Clerk clerk3 = new Clerk();
	

	ArrayList<Clerk> clerk = new ArrayList<Clerk>();
	
	
	
	
	
	public void service(ArrayList<User> userList){
	
		
		clerk.add(clerk1);
		clerk.add(clerk2);
		clerk.add(clerk3);
	
	
		ArrayList<User> waitingUser = new ArrayList<User>();
		User u;
		int totalWaiting = 0;
		
		
		for(time=0;;time++){
			

			
			
			for(int i=0;i<userList.size();i++){
				u = userList.get(i);
				if(u.arrivalTime == time)
					waitingUser.add(u);
			}
				
			
			if(waitingUser.isEmpty()==true 
					&& clerk.get(0).available==true
					&& clerk.get(1).available==true 
					&& clerk.get(2).available==true){
		
				System.out.println("FIFO SERVICE");
				System.out.println("총 소요시간 : " + time);
				System.out.println("총 대기 시간 : " + totalWaiting);
				
				break;
				
			}
						
			for(int i=0;i<clerk.size();i++){
				if(clerk.get(i).available == true && waitingUser.isEmpty() == false){
					
					waitingUser.get(0).ticketingStartTime = time;
					clerk.get(i).ticketing(waitingUser.get(0), time);
					totalWaiting += waitingUser.get(0).ticketingWaitTime;
					System.out.println(waitingUser.get(0).name + "	" +waitingUser.get(0).ticketingWaitTime);  
					waitingUser.remove(0);
					
					if(clerk.get(i).waiting == time){
						clerk.get(i).available = true;
					}
					
				}else{
					if(clerk.get(i).waiting == time){
						clerk.get(i).available = true;
					}
				}
			}

		}
		
		
	}
}
