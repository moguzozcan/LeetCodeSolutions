package easy;

/*
Difficulty: Easy
Companies: Facebook

The API: int read4(char *buf) reads 4 characters at a time from a file.

The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.

By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

Note:
The read function will only be called once for each test case.
Thoughts
This is an easy question but we need to get the meaning of requirements correct.
At the beginning, I thought read4 function is reading characters from buf. So does the function read. But that’s not correct.

The meaning here is that read4() function will read 4 characters at a time from a file and then put the characters that has been read into this buf variable.
So read() function is reading at most n characters from a file ( we don’t know what file and how it’s reading from the file), and put x characters into char[] buf.
 */

public class LC_157_ReadNCharactersGivenRead4 {

    public int read(char[] buf, int n) {
        boolean eof = false;
        int total = 0;
        char[] tmp = new char[4];
        int current;

        while(!eof && total < n) {
            current = read4();
            eof = current < n;

            current = Math.min(current, n - total);

            for(int i = 0; i < current; i++) {
                buf[total++] = tmp[i];
            }
        }

        return total;
    }

    private int read4() {
        return 0;
    }

}
