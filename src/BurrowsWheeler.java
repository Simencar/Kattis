import java.util.Arrays;

public class BurrowsWheeler {

    public static class Suffix implements Comparable<Suffix> {
        int index;
        int rank;
        int nextRank;


        public Suffix(int index, int rank, int nextRank) {
            this.index = index;
            this.rank = rank;
            this.nextRank = nextRank;
        }

        @Override
        public int compareTo(Suffix other) {
            int c1 = Integer.compare(this.rank,other.rank);
            int c2 = Integer.compare(this.nextRank, other.nextRank);
            return (this.rank != other.rank) ? c1 : c2;
        }
    }

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        String line;
        while ((line = io.getLine()) != null) {
            int n = line.length();
            line = line+line; //double input to avoid using EOF char.
            Suffix[] suffixes = suffixArr(line);
            for(int i = 0; i < line.length(); i++) {

                if(suffixes[i].index < n) { //within bounds of original string
                    int index = (suffixes[i].index > 0) ? (suffixes[i].index-1) : (n-1);
                    io.print(line.charAt(index)); //character at index-1 will be the last column after a left shift
                }
            }
            io.println();
        }
        io.close();

    }

    static Suffix[] suffixArr(String text) {
        int n = text.length();
        Suffix[] suffixes = new Suffix[text.length()];
        for (int i = 0; i < n; i++) {
            //initialize suffix. rank is first char value
            suffixes[i] = new Suffix(i, text.charAt(i), 0);
        }
        for(int i = 0; i < n; i++) {
            // set nextRank for each suffix to rank of suffix i+1(value of next adjacent char)
            suffixes[i].nextRank = (i + 1 < n) ? (suffixes[i+1].rank) : (-1);
        }
        Arrays.sort(suffixes); //sort suffixes according to first and second char.

        int[] ind = new int[n];
        //sort suffixes according to length of power of 2 characters
        for(int l = 4; l < 2*n; l *= 2) {
            int rank = 0;
            int prev = suffixes[0].rank;
            suffixes[0].rank = rank;
            ind[suffixes[0].index] = 0;
            for(int i = 1; i < n; i++) {
                //first and second rank are identical as previous suffix, set same rank for this suffix
                if(suffixes[i].rank == prev && suffixes[i].nextRank == suffixes[i-1].nextRank) {
                    prev = suffixes[i].rank;
                    suffixes[i].rank = rank;
                }
                //not same, increment rank
                else {
                    prev = suffixes[i].rank;
                    suffixes[i].rank = ++rank;
                }
                ind[suffixes[i].index] = i; //keep track of next suffix after this one.
            }
            //set nextRank for each suffix to the rank of the suffix starting at nextIndex
            for(int i = 0; i < n; i++) {
                int nextIndex = suffixes[i].index + l / 2;
                suffixes[i].nextRank = (nextIndex < n) ? (suffixes[ind[nextIndex]].rank) : (-1); // set to -1 if no suffix here
            }
            //sort suffixes according to first l characters
            Arrays.sort(suffixes);
        }
        return suffixes;
    }
}
