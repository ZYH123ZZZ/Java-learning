# 归档代码 2026-11-20 ~ 11-22

> 从 `C:\Users\Administrator\Desktop\test\src` 移出来的复习/练习代码，原地只剩 `guessNum.java`。
> 编译运行：把单个文件复制到临时目录再 `javac`/`java`，别放回 src —— 这些类名在同一默认包里会撞。
> 跑 java 时记得 `"-Dstdout.encoding=UTF-8"` 带引号，否则 pwsh 会把 `-D` 吃掉。

## 2026-11-20（第 9、10、13、14 条到期）

| 文件 | 对应 | 结果 |
|---|---|---|
| `checkR9.java` | 第 9 条 递归跨层状态（`find` 收关键词文件） | **不过**（提示一次仍写不出合并 → 11-27 重考） |
| `checkR9B.java` | 第 9 条加练 · `totalSize` 递归求和 | 过（26 / 11、3 / 0 / 0 六行全对，零提示） |
| `checkR10.java` | 第 10 条 Iterator 边界 + 单行道（`trimBelowAvg`） | **过**（4 判据 + 4 组隐藏边界，零提示） |
| `checkR13.java` | 第 13 条 逐块比两文件（`isCompareTrue`） | 临时过（第一版单 buf 共用 + 每轮多读一块 + 比返回值） |
| `checkR13B.java` | 第 13 条加练 · `firstDiff` 找第一个不同位置 | 十版才全过（隐藏 6「前缀且填充同色」卡死 → 残留缓冲） |
| `checkR13C.java` | 第 13 条单点题 · `firstDiffInBlock` | 4 判据全过（`min` 写成 max 改一次） |
| `checkR14.java` | 第 14 条 多流 try 套层（`merge` 多文件合并） | 临时过（首版 `out.write(n)` 写的是返回值不是内容） |
| `checkR14B.java` | 第 14 条加练 · `ensure` 不存在就建、长度对就不许碰 | **过**（5 判据，零提示） |
| `checkR14C.java` | 第 14 条换骨架 · `interleave` 两文件轮流搬块 | **过**（4 判据 + 4 隐藏，零提示；三个流同一层 try） |
| `checkR23A.java` | 缓冲区残留单点题 · `sumBytes` 逐字节求和 | **过**（4 判据 + 5 隐藏，`i < n` 写对） |
| `DemoBuf.java` | 教学演示 · 残留缓冲"假相等" | 演示件（1024 个 x vs 1029 个 x，第 2 轮硬比 1024 格仍相等） |

## 2026-11-21 ~ 11-22（第 11、12 条）

| 文件 | 对应 | 结果 |
|---|---|---|
| `checkR11A.java` | 第 11 条 File 返回值语义 · `dirSize` | 提示一次才改对（子目录结果被 `return` 掉） |
| `checkR11B.java` | 换方法 · `census` 分类计数 | 两轮提示后 4 判据 + 6 隐藏全过 |
| `checkR11C.java` | 换问法 · `largest` 最大文件 | 4 判据过，隐藏：空子目录 NPE、只有 0 字节文件返回目录 |
| `checkR11D.java` | 换问法 · `extremes` 最大最小 | 4 判据 + 8 隐藏全过（三处 null 是我指出的） |
| `checkR12.java` | 第 12 条 字节流 copy | 4 判据 + 3 隐藏过（首版 `in.read()` 当成"读到几个"） |
| `checkR12B.java` | 换方法 · `copyHead` 只搬前 n 个 | take 版 4 判据 + 10 隐藏过（源比 n 短那组靠提示） |

## 已删（他说不做了，等学完编排训练再说）

- `checkR11E.java` —— `firstEmptyDir` 找第一个空目录（出了题，没写）
- `checkR12C.java` —— `copyRange` 带 start/len（六版没过，转成训练文档 T1/T6）

## 下次要看的

- `checkR13B.java` —— 隐藏 6 那一版：为什么 `nA = -1` 时 `bufA` 还是上一块的 1024 个 `x`
- `checkR11C.java` —— 空子目录返回 null 把整棵树作废，跟 `checkR11D` 的 `continue` 对比
