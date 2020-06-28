import java.util.HashMap;

public class AddingWords {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        HashMap<String, Integer> vals = new HashMap<>();
        while (io.hasMoreTokens()) {
            String cmd = io.getWord();

            if (cmd.equals("clear")) {
                vals.clear();
            }

            if (cmd.equals("def")) {
                String vName = io.getWord();
                int val = io.getInt();
                vals.put(vName, val);
            }

            if (cmd.equals("calc")) {
                String symb;
                StringBuilder stringRep = new StringBuilder();
                boolean unknown = false;
                boolean plus = true;
                boolean minus = false;
                int sum = 0;
                
                while (!(symb = io.getWord()).equals("=")) {
                    if (symb.equals("-")) {
                        stringRep.append(symb + " ");
                        minus = true;
                        plus = false;
                    } else if (symb.equals("+")) {
                        stringRep.append(symb + " ");
                        minus = false;
                        plus = true;
                    } else {
                        stringRep.append(symb + " ");
                        if (vals.containsKey(symb)) {
                            if (plus) {
                                sum += vals.get(symb);
                            }
                            if (minus) {
                                sum -= vals.get(symb);
                            }
                        }
                        else {
                            unknown = true;
                        }
                    }
                }


                if (vals.containsValue(sum) && !unknown) {
                    for (String key : vals.keySet()) {
                        if (vals.get(key) == sum) {
                            stringRep.append("= " + key);
                            break;
                        }
                    }
                }
                else {
                    stringRep.append("= unknown");
                }

                io.println(stringRep.toString());
                io.flush();
            }


        }
        io.close();

    }
}
