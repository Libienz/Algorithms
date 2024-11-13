import java.util.*;

class Solution {

    private static int answer = 0;
    private static List<List<Integer>> candidateKeys = new ArrayList<>();

    public int solution(String[][] relation) {
        int columnLength = relation[0].length;

        for (int i = 0; i<columnLength; i++) {
            List<Integer> selectedColumns = new ArrayList<>();
            dfs(i, relation, selectedColumns);
        }

        System.out.println(candidateKeys);
        return candidateKeys.size();
    }

    public void dfs(int columnNumber, String[][] relation, List<Integer> selectedColumns) {
        if (columnNumber >= relation[0].length) {
            System.out.println(selectedColumns);
            if (isCandidateKey(selectedColumns, relation)) {
                candidateKeys.add(copyList(selectedColumns));
            }
            return;
        }

        // selectedColumns.remove(selectedColumns.size()-1);
        List<Integer> copy = copyList(selectedColumns);
        dfs(columnNumber+1, relation, copy);

        copy = copyList(selectedColumns);
        copy.add(columnNumber);
        dfs(columnNumber+1, relation, copy);
    }

    public boolean isCandidateKey(List<Integer> selectedColumns, String[][] relation) {
        if (selectedColumns.isEmpty()) {
            return false;
        }

        Set<String> duplicateCheckSet = new HashSet<>();
        for (String[] row : relation) {
            String key = "";
            for (int selectedColumn : selectedColumns) {
                key += row[selectedColumn];
            }
            duplicateCheckSet.add(key);
        }

        return relation.length == duplicateCheckSet.size() && isCandidateKeyNotDuplicated(selectedColumns);
    }

    public boolean isCandidateKeyNotDuplicated(List<Integer> selectedColumns) {
        if (candidateKeys.isEmpty()) {
            return true;
        }
        for (List<Integer> candidateKey : candidateKeys) {
            if(selectedColumns.containsAll(candidateKey)) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> copyList(List<Integer> target) {
        List<Integer> copy = new ArrayList<>();
        for (Integer element : target) {
            copy.add(element);
        }

        return copy;
    }
}