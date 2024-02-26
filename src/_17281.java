import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class _17281{
    static int N;
    static List<List<Integer>> v = new ArrayList<>();
    static boolean print = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            List<Integer> inning = new ArrayList<>();
            for (int j = 0; j < 9; j++) {
                inning.add(scanner.nextInt());
            }
            v.add(inning);
        }

        List<Integer> e = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            e.add(i);
        }
        Collections.sort(e); // 초기 정렬 (사실상 필요 없음, 이미 순서대로 추가됨)
        int maxScore = 0;

        do {
            if (print) {
                System.out.println("순서");
                e.forEach(player -> System.out.print(player + " "));
                System.out.println();
            }

            int totalScore = 0;
            int playIdx = 0;
            for (int i = 0; i < N; i++) {
                List<Integer> curInning = new ArrayList<>();
                int idx = 0;
                for (int j = 0; j < 9; j++) {
                    if (j == 3) curInning.add(v.get(i).get(0));
                    else curInning.add(v.get(i).get(e.get(idx++)));
                }

                if (print) {
                    System.out.println("주자 점수");
                    curInning.forEach(score -> System.out.print(score + " "));
                    System.out.println();
                }

                int out = 0;
                int score = 0;
                int[] bases = new int[4]; // 0: 홈, 1: 1루, 2: 2루, 3: 3루

                while (out < 3) {
                    int now = curInning.get(playIdx++);
                    if (playIdx > 8) playIdx = 0;

                    if (now == 0) {
                        out++;
                    } else if (now >= 1 && now <= 3) {
                        for (int j = 3; j >= 1; j--) {
                            if (bases[j] == 1) {
                                if (j + now > 3) {
                                    score++;
                                } else {
                                    bases[j + now] = 1;
                                }
                                bases[j] = 0;
                            }
                        }
                        bases[now] = 1;
                    } else {
                        score++; // 타자 자신의 점수
                        for (int j = 1; j <= 3; j++) {
                            score += bases[j];
                            bases[j] = 0; // 홈으로 들어옴
                        }
                    }
                }
                totalScore += score; // 매 이닝 끝나면 점수 합산
                if (print)
                    System.out.printf("score: %d, totalScore: %d\n", score, totalScore);
            }
            maxScore = Math.max(maxScore, totalScore); // 매 경기 끝나면 최대 점수 구하기
        } while (Collections.nextPermutation(e));
        System.out.println(maxScore);
    }

    // Java에서는 Collections 클래스에 nextPermutation 메소드가 없으므로, 이를 직접 구현해야 합니다.
    // 여기에 nextPermutation 메소드 구현 필요. 하지만 이 예제에서는 생략되었습니다.
    // Collections.nextPermutation(e) 호출 부분은 적절한 순열 생성 코드로 대체해야 합니다.
}
