//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


class GFG {
	public static void main(String[] args) throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(stt.nextToken());
            long k = Long.parseLong(stt.nextToken());
            
            long a[] = new long[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            Solution obj = new Solution();
            out.println(obj.countSubArrayProductLessThanK(a, n, k));
        }
        out.close();
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution {
    
    public long countSubArrayProductLessThanK(long a[], int n, long k)
    {
        //brute force
       /* long res = 0;
        for(int i=0;i<n;i++){
            long prod=1;
            for(int j=i;j<n;j++){
                prod*=a[j];
                if(prod<k) res++;
                else break;
            }
        }
        return res;*/
        
        long p = 1;
        long res = 0;
        for (int start = 0, end = 0; end < n; end++) {
            p *= a[end];
            // Move left bound so guarantee that p is again
            // less than k.
            while (start < end && p >= k) p /= a[start++];
    
            // If p is less than k, update the counter.
            // Note that this is working even for (start == end):
            // it means that the previous window cannot grow
            // anymore and a single array element is the only
            // addendum.
            if (p < k) {
                int len = end - start + 1;
                res += len;
            }
        }
    
        return res;
    }
}