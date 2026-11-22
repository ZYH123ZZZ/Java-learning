# 归档代码 2026-11-18 ~ 11-19

> 从 `C:\Users\Administrator\Desktop\test\src` 移出来的复习/练习代码，原地已清空（只剩 `guessNum.java`）。
> 编译运行：把单个文件复制到临时目录再 `javac`/`java`，别放回 src —— 这些类名在同一默认包里会撞。

## 2026-11-18（八条复习，台账第 1–6 条）

| 文件 | 对应 | 结果 |
|---|---|---|
| `checkR1.java` | 第 1 条 switch | 临时过 |
| `checkR2.java` | 第 2 条 indexOf / lastIndexOf / substring | 临时过 |
| `checkR3.java` | 第 3 条 嵌套循环 | 过 |
| `checkR4.java` / `checkR4B.java` | 第 4 条 冒泡排序 | 不过（11-25 重考） |
| `checkR5.java` / `checkR5B.java` / `checkR5C.java` | 第 5 条 接口方法强转 | 不过（11-25 重考） |
| `checkR6.java` | 第 6 条 抛异常后 try 截断 | 过 |

## 2026-11-19（第 7、8 条复习 + 两个新学）

| 文件 | 对应 | 结果 |
|---|---|---|
| `checkR7.java` | 第 7 条 递归出口（本体，`sum` / `maxOf`） | 不过（11-26 重考） |
| `checkR7A.java` | 递归出口变式 · 斐波那契 | 一次过 |
| `checkR7B.java` | 递归出口变式 · `countGT` + `joinAll` | 一次过 |
| `checkR7C.java` | 递归出口变式 · `rev` + `digitSum` | 一次过（自己想的"从尾部切"写法） |
| `checkR7D.java` | 递归出口变式 · `gcd` + `isPal` | 一次过（`gcd` 零提示） |
| `checkR7E.java` | 递归出口变式 · `toBinary` + `sumHalf` | `sumHalf` 对（空区间判据有洞）；`toBinary` **空着没写** |
| `checkR8.java` | 第 8 条 `T...` 变参 | 临时过 |
| `checkE1.java` | 新学 · 封装 `Account` | 临时过（构造方法改 4 版） |
| `checkE2.java` | 新学 · 封装 `Stock`（无 setter / 返回 boolean / 派生值） | 临时过（`low()` 判反改 1 版） |
| `checkS1.java` | 新学 · static `Order` | B+（8 行一次全对） |

## 11-26 重考要看这两个

- `checkR7.java` —— 出口写成 `return a[0]` 那次
- `checkR7E.java` —— `toBinary` 还没写、`sumHalf` 的空区间判据（`lo == 0 && hi == -1`）有洞
