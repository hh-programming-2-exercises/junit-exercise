# Floating-Point Inaccuracy

While working on this repository task, you may run into a strange situation where the number under test appears to round incorrectly. This may happen especially when you use a value in your test that falls exactly halfway between hundredths, for example `0.005`.

The problem can be illustrated, for example, by calculating `0.1 + 0.2` or by taking the remainder of `123_456.555` divided by 1. You might expect the results to be `0.3` and `0.555`, but that is not quite the case:

```java
System.out.println(0.1 + 0.2);          // should print 0.3
0.30000000000000004

System.out.println(123_456.555 % 1);    // should print 0.555
0.5549999999930151
```

The fact that very small errors occur when handling floating-point numbers is not caused by Java, unit tests, or the code being tested, but by how computers represent numbers. [ChatGPT](https://chat.openai.com/) explains this clearly, so here is its explanation of the phenomenon:

> *Computers use floating-point logic to store and process decimal numbers. This logic uses the binary system, which consists of zeros and ones. This causes certain precision issues when working with decimal numbers.*
>
> *Most decimal numbers cannot be represented exactly in binary. For example, a computer represents the number 1/10 in binary as an infinite decimal-like expansion that repeats certain digits forever (0.0001100110011...). This leads to precision issues when decimal numbers are converted to binary and back.*
>
> *This means that when decimal numbers are converted to binary form, their exact representation may require infinitely many binary digits. Computers cannot store an infinite number of digits in memory, so they must cut and round values, which causes loss of precision.*
>
> *This loss of precision causes small deviations in decimal representations, especially in calculations where rounding and truncation accumulate, producing small errors in final results. These errors are called floating-point precision issues, and they are characteristic of all computers that use floating-point logic for decimal calculations.*
>
> ChatGPT (GPT-3.5). https://chat.openai.com/. 8 Nov 2023

As a solution to avoid floating-point precision problems in this exercise, we recommend using test values that are slightly away from exact halfway points between hundredths. This precision issue is not intentionally part of this exercise; it is simply a natural part of how computers work.

You can read more about the technical implementation and limitations of floating-point numbers in the article ["What Every Computer Scientist Should Know About Floating-Point Arithmetic" (oracle.com)](https://docs.oracle.com/cd/E19957-01/806-3568/ncg_goldberg.html).
