# merge

## MergeSort 归并排序代码

#### 原理 <br>  
**归并排序** <br>  

**分治思想**： <br>
**总的特征**：结构上具有递归特性<br>
**分**：将原问题分成若干较小的问题<br>
**治**：分别处理小问题，极小问题直接处理<br>
**合**：以小问题的解构建原问题的解<br>
  
#### 方案图示
  ![avatar](https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1535342366497&di=cbd17c5729871f95829769c9daaea2c4&imgtype=0&src=http%3A%2F%2Fwww.vfast.com.cn%2Fuploadfile%2F2017%2F1130%2F20171130054558466.jpg)
#### 算法性能
归并排序的时间复杂度为nlgn <br>
空间复杂度为n。

#### 验证
排序1亿个数，理论上占用1亿*4B*2=400MB*2=800MB内存，进程实际1200+（多出的应该是java类库等占用的），cpu 100%了。在我的mac上耗时近25秒
cpu配置：2.2 GHz Intel Core i7
  
  
#### 拓展
链表排序，归并
外层排序
优先级队列


<p></p>

## KLineMergeSort 多路归并
#### 原理：
将k路排好序的数组，合并成1路  

利用优先级队列，快速取出各路之间第一个值最小的1路，并将最小值放入新数组中
!["多路归并原理"](
https://github.com/chengtianshuang/ita/blob/master/photo/%E5%A4%9A%E8%B7%AF%E5%BD%92%E5%B9%B6%E5%8E%9F%E7%90%86.jpeg)

#### 算法性能：
时间复杂度： <br>
空间复杂度：n

