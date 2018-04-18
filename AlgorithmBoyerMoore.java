public class AlgorithmBoyerMoore
{
    public static void AlgorithmBoyerMoore(String str, String pattern)
    {
        int len = pattern.length() - 1;//длина шаблона от нуля

        //таблица смещения
        int arr[] = new int[256]; //индексируем символы с помощью ASCII табл

        //инициализация таблицы смещения
        for (int i = 0; i < arr.length; i++)
            arr[i] = pattern.length();

        //заполнение таблицы смещения
        for (int i = len - 1; i >= 0; i--)
        {
            //определение текущего символа
            int temp;
            temp = Character.valueOf(pattern.charAt(i));

            //если символ еще не встречался, то вносит его в таблицу по правилам
            if (arr[temp] == pattern.length())
                arr[temp] = len  - i;
        }

        //текущие сравниваемые символы строки и шаблона
        int temp_ch_str = len;
        int temp_ch_pt = len;

        //проходит по всей строке
        while (temp_ch_str < str.length())
        {

            //если в шаблоне остались символы И символ шаблона совпадает с символом строки
            //то уменьшет длину шаблона
            if ((temp_ch_pt >= 0) && (str.charAt(temp_ch_str - (len - temp_ch_pt)) == pattern.charAt(temp_ch_pt)) )
                temp_ch_pt--;

            //иначе восстанавливает длину шаблона и передвигаемся по строке, ииспользуя табл смещения
            else
            {
                //если длина шаблона ноль, то выводим позицию вхождения
                if (temp_ch_pt < 0)
                    System.out.println(temp_ch_str - len + 1);

                temp_ch_pt = len;
                temp_ch_str += arr[Character.valueOf(str.charAt(temp_ch_str))];
            }

        }

    }

}
