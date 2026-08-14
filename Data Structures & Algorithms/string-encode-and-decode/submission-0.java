class Solution {

    public String encode(List<String> strs) {
        if (strs.isEmpty()) return "";
        return strs.stream().map(str -> "{" + str.length() + "}" + str).collect(Collectors.joining());
    }

    public List<String> decode(String str) {
        List<String> output = new ArrayList<>();
        int i = 0;
        while(i < str.length()) {
            // If we see a open bracket: 
            // - find the substring going until the close bracket
            // - turn that substring into a number
            // substring that many characters ahead
            // add to list
            // set i to big number
            // if bracket keep going if bigger stop
            int startRange = str.indexOf("{", i);
            int endRange = str.indexOf("}", i);
            if(startRange < 0 || endRange < 0) break;
            int number = Integer.parseInt(str.substring(startRange + 1, endRange));
            String toAdd = str.substring(endRange + 1, endRange + number + 1);
            output.add(toAdd);
            i = endRange + number + 1;

        }

        return output;
    }
}
