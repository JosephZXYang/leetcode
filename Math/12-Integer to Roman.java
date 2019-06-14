/**

Key points:

    1. Simple math problem. EZAF. Just cover all possible cases in order.

Difficulty: Medium

*/

class Solution {
    public String intToRoman(int num) {
        int copy = num;
        String s = "";
        
        while (copy > 0) {
            if (copy >= 1000) {
                s += "M";
                copy -= 1000;
            }
            else if (copy >= 900) {
                s += "CM";
                copy -= 900;
            }
            else if (copy >= 500) {
                s += "D";
                copy -= 500;
            }
            else if (copy >= 400) {
                s += "CD";
                copy -= 400;
            }
            else if (copy >= 100) {
                s += "C";
                copy -= 100;
            }
            else if (copy >= 90) {
                s += "XC";
                copy -= 90;
            }
            else if (copy >= 50) {
                s += "L";
                copy -= 50;
            }
            else if (copy >= 40) {
                s += "XL";
                copy -= 40;
            }
            else if (copy >= 10) {
                s += "X";
                copy -= 10;
            }
            else if (copy >= 9) {
                s += "IX";
                copy -= 9;
            }
            else if (copy >= 5) {
                s += "V";
                copy -= 5;
            }
            else if (copy >= 4) {
                s += "IV";
                copy -= 4;
            }
            else if (copy >= 1) {
                s += "I";
                copy -= 1;
            }
        }
        return s;
    }
}