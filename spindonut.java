public class SpinningDonut {
    public static void main(String[] args) throws InterruptedException {
        double A = 0, B = 0;
        int width = 40, height = 12;
        double[] z = new double[1760];
        char[] b = new char[1760];

        System.out.print("\u001b[2J");
        for (; ; ) {
            java.util.Arrays.fill(b, 0, 1760, ' ');
            java.util.Arrays.fill(z, 0, 1760, 0);
            for (double j = 0; 6.28 > j; j += 0.07)
                for (double i = 0; 6.28 > i; i += 0.02) {
                    double c = Math.sin(i),
                            d = Math.cos(j),
                            e = Math.sin(A),
                            f = Math.sin(j),
                            g = Math.cos(A),
                            h = d + 2,
                            D = 1 / (c * h * e + f * g + 5),
                            l = Math.cos(i),
                            m = Math.cos(B),
                            n = Math.sin(B),
                            t = c * h * g - f * e;
                    int x = (int) (width / 2 + 30 * D * (l * h * m - t * n)),
                            y = (int) (height / 2 + 15 * D * (l * h * n + t * m)),
                            o = x + width * y,
                            N = (int) (8 * ((f * e - c * d * g) * m - c * d * e - f * g - l * d * n));
                    if (height > y && y > 0 && width > x && x > 0 && D > z[o]) {
                        z[o] = D;
                        b[o] = ".,-~:;=!*#$@" .charAt(Math.max(N, 0));
                    }
                }
            System.out.print("\u001b[H");
            for (int k = 0; 1761 > k; k++)
                System.out.print(k % width > 0 ? b[k] : 10);
            A += 0.04;
            B += 0.02;
            Thread.sleep(30);
        }
    }
}
