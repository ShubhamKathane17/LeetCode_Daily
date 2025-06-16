// 735. Asteroid Collision\
// optimal approach - using stack to keep track of the remaining asteroids after collision
// tc - O(n) every element is visited only once
// sc - O(n) stack and list to store the elements

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        int end = n - 1;
        Stack<Integer> stack = new Stack<>();

        while (end >= 0) {
            int curr = asteroids[end];

            if (stack.isEmpty()) {
                stack.push(curr);
                end--;
                continue;
            }

            if (stack.peek() < 0 && curr > 0) {
                int temp = stack.pop();
                if (Math.abs(temp) < Math.abs(curr)) {
                    continue;
                } else if (Math.abs(temp) > Math.abs(curr)) {
                    stack.push(temp);
                    end--;
                } else {
                    end--;
                    continue;
                }
            } else {
                stack.push(curr);
                end--;
                continue;
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (!stack.isEmpty()) {
            ans.add(stack.pop());
        }

        int[] res = new int[ans.size()];
        int start = 0;
        for (int a : ans) {
            res[start++] = a;
        }

        return res;
    }
}
