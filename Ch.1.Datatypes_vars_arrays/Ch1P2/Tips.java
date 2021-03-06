public class Tips {

    /* В классе Tips будут собраны все пройденные на уроке техники или трюки манупуляции кодом и данными */
    /* Все нижеописанное поможет выполнить домашнее задание и закрепить пройденный материал */
    /* Урок 1.2 - Правила приведения типов данных в Java */

    public static void main(String args[]){

        // В Java существует 2 типа преобразования:
        // 1 - Автоматическое преобразование(неявное)
        // 2 - Приведение типов(явное)


        /* 1 - Автоматическое(неявное) преобразование */

        // Оно выполняется при соблюдении 2 условий:
        // 1 - Преобразуемый тип данных совместим с целевым
        // 2 - Длина целевого типа больше длины исходного типа
        // Не существует автоматического преобразования для комбинаций:
        // 1) Целочисленный тип -> символьный тип(char)
        // 2) Целочисленный тип -> логический тип(boolean)
        // Типы char и boolean - несовместимы

        // Убедимся в этом

        // 1-пример
        System.out.println("--Автоматическое преобразование--\n");

        int a; //целевой тип
        byte c = 127; // исходный тип

        a = c; // Произошло автоматическое(неявное) преобразование целочисленных типов данных
               // Были выполнены оба условия:
               // 1) int и byte совместимы
               // 2) длина int больше длины byte

        System.out.println("byte to int: " + a);

        // 2-пример
        int b; //целевой тип
        short d = 32767; // исходный тип

        b = d; // Произошло автоматическое(неявное) преобразование целочисленных типов данных
               // Были выполнены оба условия:
               // 1) int и short совместимы
               // 2) длина int больше длины short

        System.out.println("short to int: " + b);

        // 3-пример
        long f; // Целевой тип
        int e = 887982734; //Исходный тип

        f = e; // Произошло автоматическое(неявное) преобразование целочисленных типов данных
               // Были выполнены оба условия:
               // 1) long и int совместимы
               // 2) длина long больше длины int

        System.out.println("int to long: " + f);

        //Автоматическое преобразование работает и для комбинации "плавающая точка" - "целочисленный тип", но не наоборот

        // 4-пример
        float q;
        int w = 323132;

        q = w; // Произошло автоматическое(неявное) преобразование целочисленного типа в тип с плавающей точкой
               // Были выполнены оба условия:
               // 1) long и int совместимы
               // 2) длина long больше длины int

        System.out.println("int to float: " + q);

        /* !!!Warning!!! */
        // преобразование типа с плавающей точкой в целочисленный тип автоматически не происходит
        // его нужно задавать с помощью приведения типов(явное преобразование)

        /* 2 - Приведение типов(явное преобразование) */

        // Не работает для комбинаций:
        // 1) Целочисленный тип -> логический и наоборот
        // 2) Символьный тип -> логический и наоборот

        // Общая схема приведения: (целевой тип) значение

        // Существует 2 типа явного преобразования:
        // 1) Сужающее преобразование
        // 2) Усечение

        System.out.println("\n--Приведение типов--");

        // Рассмотрим эти типы по отдельности

        /* 1 - Сужающее преобразование */

        // При таком преобразовании значение сужается, чтобы поместиться в целевом типе
        // Для сужения используется операция деления по модулю диапазона целевого типа
        // То есть операция взятия остатка от деления значения на диапазон целевого типа

        System.out.println("\n1)Сужающее преобразование");

        // 1-пример
        byte r; // Целевой тип
        int t = 267; // Исходное значение

        r = (byte) t; // Произошло сужающее приведение, так как значение не помащается в целевом типе
                      // После приведения в r хранится значение равное 267 % 256 = 11, где 256 - диапазон типа byte

        System.out.println("int to byte: " + r);

        // 2-пример
        short x; // Целевой тип
        int y = 75467; // Исходное значение

        x = (short) y; // Произошло сужающее приведение, так как значение не помащается в целевом типе
        // После приведения в x хранится значение равное 75467 % 65536 = 9931, где 65536 - диапазон типа short

        System.out.println("int to short: " + x);

        /* !!Warning!! */
        // Если исходное значение не помещается в целевой тип, но оно меньше диапазона целевого типа, то:
        // положительное исходное значение циклически сдвигается в отрицательную часть диапазона
        // отрицательное исходное значение циклически сдвигается в положительную часть диапазона
        // Но не стоит увлекаться такими преобразованиями, так как их расчет очень тонкое дело
        // И часто можно допустить ошибку при расчете в данных преобразованиях

        // Например

        byte p; // Целевой тип
        int l = 128; // Исходное значение - не помещается в byte, но больше меньше диапазона byte, то есть < 256

        p = (byte) l; // После сужения в p будет хранится -128, так как исходное значение было положительным

        System.out.println("int(< диапазон byte) to byte : " + p);

        /* 1 - Усечение */

        System.out.println("\n2)Усечение");

        // Данный вид приведения используется при присвоении литералов типов с плавающей точкой целочисленным типам данных
        // При этом дробная часть литерала с плавающей точкой отбрасывается, а не округляется
        // Если полученное путем отброса целое число не помещается в целевой тип, то происходит сужение

        // 1-пример
        int n; // Целевой тип
        float m = 8979879.879f; // Исходное значение

        n = (int) m; // Произошло усечение: остаток отбросился

        System.out.println("float to int: " + n);

        // 2-пример
        long h; // Целевой тип
        double v = 8979899879.889898079d; // Исходное значение

        h = (long) v; // Произошло усечение: остаток отбросился

        System.out.println("double to long: " + h);

        /* 3 - Автоматическое продвижение типов */

        // В Java определен ряд правил продвижения типов, применяемых к выражениям
        // Сначала все типы byte, short, char продвигаются к типу int
        // Затем, если в выражении есть тип long, то все выражение продвигается к типу long
        // Если же один из операндов относится к типу float, то выражение продвигается к типу float
        // Если любой из опрендов относится к типу double, то выражение продвигается к типу double

        System.out.println("\n--Автоматическое продвижение типов--");

        // Пример

        byte bb = 35;
        char cc = 'q';
        short ss = 1111;
        int ii = 555555;
        float ff = 332.4f;
        double dd = 0.2930;

        double res = (ff * bb) + (ii / cc) - (dd * ss);

        // Рассмотрим как происходит продвижение
        // ff * bb продвигается к типу float
        // ii / cc продвигается к типу int
        // dd * ss продвигается к типу double
        // в итоге все выражение продвигается к типу double

        System.out.println("Result is double: " + res);


    }

}
