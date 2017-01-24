import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class TheStockSpanProblem {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));
        try{
            int size = Integer.parseInt(Console.readLine());
            int price[] = new int[size];
            for (int i = 0; i < size; i++) {
                price[i] = Integer.valueOf(Console.readLine());
            }

            int[] asd = stockSpan(price);

            for (int i = 0; i < asd.length; i++) {
                System.out.println(asd[i]);
            }
            //int S[] = new int[size];
            //calculateSpan(price, size, S);
            //printArray(S, size);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int[] stockSpan(int[] stock) {
        // we will use stack for indexes and not for "stock values"
        int[] span = new int[stock.length];

        for (int i = 0; i < stock.length; i++) {
            int index = i - 1;
            span[i] = 1;
            while (index >= 0 && stock[index] <= stock[i]) {
                // previous member is the same or smaller price.
                // that member, plus all of its span, are also smaller.
                span[i] += span[index];
                // we can skip the span and check if the next span is smaller too.
                index -= span[index];
            }
        }

        // System.out.printf("Input %s -> SPans %s%n",
        //        Arrays.toString(stock), Arrays.toString(span));
        return span;
    }
    // A stack based efficient method to calculate stock span values
    static void calculateSpan(int price[], int n, int S[])
    {
        // Create a stack and push index of first element to it
        ArrayDeque<Integer> st = new ArrayDeque<>();
        st.push(0);

        // Span value of first element is always 1
        S[0] = 1;

        // Calculate span values for rest of the elements
        for (int i = 1; i < n; i++)
        {
            // Pop elements from stack while stack is not empty and top of
            // stack is smaller than price[i]
            while (!st.isEmpty() && price[st.peek()] <= price[i])
                st.pop();

            // If stack becomes empty, then price[i] is greater than all elements
            // on left of it, i.e., price[0], price[1],..price[i-1].  Else price[i]
            // is greater than elements after top of stack
            S[i] = (st.isEmpty())? (i + 1) : (i - st.peek());

            // Push this element to stack
            st.push(i);
        }
    }

    // A utility function to print elements of array
    static void printArray(int arr[], int n)
    {
        for (int i = 0; i < n; i++)
            System.out.println(arr[i]);
    }

    // Driver program to test above function
}
