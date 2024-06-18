import java.util.*;

class Hospital_adminstrator {
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
       
        int p_id[]=new int[100];                               //patient list
        int c_id[]=new int[100];       			//copy of patient list
        Stack<Integer> st=new Stack<>();		//stack to store discharged patient list
        int ii=0;
        int temp=0;
        int size=0;
        boolean flag=true;
        HashMap<Integer,Integer> map=new HashMap<>();		//number of times a patient visited
        HashMap<Integer,String> history=new HashMap<>();	//to display the history of patients
        while(flag){
            System.out.println("1:Register new patinet");
            System.out.println("2:dispaly all patinet");
            System.out.println("3:Reverse patinet list");
            System.out.println("4:Middle patinet");
            System.out.println("5:Discharge patinet");
            System.out.println("6:Undo last patinet");
            System.out.println("7:Most Frequent patinet");
            System.out.println("8:Least frequent patinet");
            System.out.println("9:Dispaly history");
            System.out.println("10:Visit again");
            
            int n=s.nextInt();
            switch(n)
            {
                case 1:
                    {
                    System.out.println("enter the Patient id \n");
                    n=s.nextInt();
                    p_id[ii]=n;
                    c_id[ii]=p_id[ii];
                    size++;
                            ii++;
                    break;
                }
                case 2:{
                    System.out.println("Patient List");
                    for(int i=0;i<size;i++){
                        System.out.print(p_id[i]+" ");
                    }
                    System.out.println();
                    break;
                }
                case 3:{
                    System.out.println(" Reverse Patient List");
                    for(int i=size-1;i>=0;i--)
                    {
                        System.out.print(c_id[i]+" ");
                    }
                    System.out.println();
                    break;
                    
                }
                case 4:{
                    System.out.println("Middle Patient");
                    int middle=size/2;
                    System.out.println("Middle patient "+p_id[middle]);
                    break;
                }
                case 5:{
                    System.out.println("enter the patient id to be discharged");
                    
                    int r_id=s.nextInt();
                    temp=p_id[r_id-1];
                    st.push(p_id[r_id-1]);
                    p_id[r_id-1]=0;
                    for(int i=0;i<size;i++)
                        {
                                System.out.println(p_id[i]);
                        }
                    System.out.println("stack elements"+st);
                    break;
                }
                case 6:
                {
                    System.out.println(" Undo Patient List");
                    //System.out.println(st.peek());
                    p_id[temp-1]=st.peek();
                    for(int i=0;i<size;i++)
                        {
                                System.out.println(p_id[i]);
                        }
                    break;
                }
                case 7:
                {
                    int max=-1;
                    System.out.println(" Most Frequent Patient List");
                    for(int i=0;i<size;i++)
                    {
                        map.put(p_id[i],map.getOrDefault(p_id[i],0)+1);
            
                    }
                    int k_max=0;
                            for(int key:map.keySet()){
                        int val=map.get(key);
                                if(val>=max && key!=0){
                                        max=val;
                                        k_max=key;
                                }  	
                
                    }
                    System.out.println("most frequent patient "+k_max);
                    System.out.println();
                    break;
                }
                case 8:
                {
                    System.out.println("Least Frequent Patient List");
                    int min=Integer.MAX_VALUE;
                        int k_min=0;
                    for(int key:map.keySet()){
                        int val=map.get(key);
                        if(val<min && key!=0){
                        min=val;
                        k_min=key;
                        }		
                    }
                    System.out.println("least frequent patient "+k_min);
                    System.out.println();
                    break;

                }
                case 9:
                {
                    /*for(int i:map.keySet())
                    {
                        if(i==0)
                        {
                            history.put(i,"Discharged");
                        }
                        else{
                            history.put(i,"Admitted");
                        }
                    }
                    System.out.println(history);*/
                    for(int i=0;i<size;i++)
                    {
                        if(p_id[i]==c_id[i])
                        {
                            System.out.println(c_id[i]+"->Admitted");
                        }
                        else{
                            System.out.println(c_id[i]+"->Discharged");
                        }
                    }
                    break;
                }
                case 10:
                {
                    flag=false;
                    break;
                }
                

            }
		
	    }
	
    }
    

}