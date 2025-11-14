class DAA1 {
    
    public static void main(String[] args) {
        System.out.println(minWindow("adobecodebanc", "abc"));
    }
    public static String minWindow(String s, String t) {
        int[] tfreq = new int[26];
        int[] sfreq = new int[26];

        for (char ch : t.toCharArray()) {
            tfreq[ch - 'a']++;
        }

        int i = 0;
        int minLength = Integer.MAX_VALUE;
        String ans = "";

        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            sfreq[ch - 'a']++;

            while (checkFreq(tfreq, sfreq)) {
                if (j - i + 1 < minLength) {
                    minLength = j - i + 1;
                    ans = s.substring(i, j + 1);
                }

                sfreq[s.charAt(i) - 'a']--;
                i++;
            }
        }

        return ans;
    }

    static boolean checkFreq(int[] tfreq, int[] sfreq) {
        for (int i = 0; i < 26; i++) {
            if (sfreq[i] < tfreq[i]) {
                return false;
            }
        }
        return true;
    }
}





