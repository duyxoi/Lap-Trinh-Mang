import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.zip.InflaterInputStream;

public class TCPByteStream {
    public static void main(String[] args) {
        String studentCode = "B23DCCN237";
        String qCode = "Ei2H7A6Q";
        String server = "36.50.135.242";
        int port = 2206;

        String request = studentCode+";"+qCode;
        try {
            Socket socket = new Socket(server, port);
            socket.setSoTimeout(5000);
       
            System.out.println("Connecting to "+server+":"+port);

            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();

            byte[] sendData = request.getBytes();
            out.write(sendData);
            out.flush();

            byte[] buffer = new byte[1024];
            int check = in.read(buffer);

            

            if(check == -1){
                System.out.println("Can not connect to server!");
                return;
            }

            String responseServer = new String(buffer, 0,check, "UTF-8");
            responseServer.trim();
            System.out.println("Response from server: "+responseServer);

            String[] arr = responseServer.split(",");
            ArrayList<Integer> nums = new ArrayList<>();
            for(String s: arr){
                nums.add(Integer.parseInt(s));
            }

            nums.sort(null);

            for(Integer x: nums) System.out.print(x+" ");
            System.out.println();

            Integer n1 = nums.get(0),n2 = nums.get(1),d1 = n2 - n1;

            for(int i = 2;i<nums.size();++i){
                int d2 = nums.get(i) -nums.get(i-1);
                if(d2 <= d1){
                    d1 = d2;
                    n2 = nums.get(i);
                    n1 = nums.get(i-1);
                }
            }

           String result = d1+","+n1+","+n2;  
           out.write(result.getBytes("UTF-8"));
           out.flush();
           System.out.println("Send to server "+result);

       } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }             
        
    }
}
