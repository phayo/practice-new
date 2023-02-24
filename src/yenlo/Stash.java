package yenlo;

import java.io.IOException;
import java.util.ArrayList;

public class Stash {
    public int read0() throws IOException {
        if(characterQueue.isEmpty()){
            return doFileInputStreamRead();
        }

        return characterQueue.poll();
    }

    private int doFileInputStreamRead() throws IOException { //Checking for &lt; &gt; or &quot; if found replace the chars
        int nextChar = fileInputStream.read();

        if(nextChar == AMP) {
            characterQueue.offer(nextChar); // add & char to queue.

            int i = 0;
            while(i <= 2){ // read next 3 chars.
                nextChar = fileInputStream.read();
                characterQueue.offer(nextChar);
                if(nextChar == -1){
                    break;
                }
                i++;
            }
            ArrayList<Integer> arr = new ArrayList<>(characterQueue);

            if(checkEqual(less_than, arr)){ // check &lt; sequence
                int j = less_than.length;
                while(j > 0 && !characterQueue.isEmpty()){ // remove length of chars forming less_than and return the int for <
                    characterQueue.poll();
                    --j;
                }
                return LT;
            }

            if(checkEqual(greater_than, arr)){ // check &gt; sequence
                int j = greater_than.length;
                while(j > 0 && !characterQueue.isEmpty()){ // remove length of chars forming greater_than and return the int for >
                    characterQueue.poll();
                    --j;
                }
                return GT;
            }

            i = 0;

            while(nextChar != -1 && i < 2){
                nextChar = fileInputStream.read();
                arr.add(nextChar);
                if(nextChar == -1) break;
                i++;
            }

            if(checkEqual(quot, arr)){ // check &quot; sequence
                int j = quot.length;
                while(j > 0 && !characterQueue.isEmpty()){ // remove length of chars forming quot and return the int for "
                    characterQueue.poll();
                    --j;
                }
                return QUOT;
            }

            if(!characterQueue.isEmpty()){
                return characterQueue.poll();
            }
        }

        return nextChar;
    }
}
