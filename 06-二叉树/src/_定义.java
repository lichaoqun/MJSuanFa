/* 二叉树中用到的定义  ₑ ₒ ₓ ₔ ₕ ₖ ₗ ₘ ₙ ₚ ₛ ₜ ⁰ ¹ ² ³ ⁴ ⁵ ⁶ ⁷ ⁸ ⁹ ⁺ ⁻ ⁼ ⁽ ⁾ ⁿ  ˙
 * 01. 节点的度: 节点的子树的个数;
 * 02. 树的度: 树的所有节点度中的最大值;
 * 03. 叶子节点: 度为0的节点;
 * 04. 非叶子节点: 度不为0的节点; 
 * 05. 兄弟节点: 相同父节点的兄弟节点;
 * 06. 树的层数: 根节点在第一层, 根节点的子节点在第二层, 以此类推;
 * 07. 节点的深度: 从根节点到当前节点的唯一路径上的节点总数;
 * 08. 节点的高度: 从当前节点到最远叶子节点的路径上的节点总数;
 * 09. 树的深度: 树的所有节点深度的最大值;
 * 10. 树的高度: 树的所有节点高度的最大值;
 * 11. 非空二叉树的第n层, 最多拥有 2 ⁽ⁿ⁻ ¹⁾ 个节点 (等比数列通项公式 aₙ = a1 * q⁽ⁿ⁻ ¹⁾, 此时这个二叉树是满二叉树;
 * 12. 非空二叉树最多有 2ⁿ - 1个节点(等比数列求和公式, Sₙ = a1 * (1 - qⁿ) / (1 - q)), 此时的二叉树是满二叉树;
 * 13. 对于任意非空二叉树, 如果叶子节点个数为n0, 度为2的节点个数为n2, 则有 n0 = n2 + 1;
 * 		推导 : 假定度为1的节点的个数为n1, 度为2的节点的个数为n2, 度为0的节点的个数为n0, 所有节点个数为 n;  即 n = n0 + n1 + n2;
 * 		二叉树的边数 = (每个节点的个数 * 每个节点的度) 的和; 即 T= n0 * 0 + n1 * 1 + n2 * 2;
 * 		二叉树的边数 = (所有节点的个数(每个节点的顶部都有边) - 1(根节点的顶部没有边)) 即 T = n - 1;
 * 		换算 T =  n0 * 0 + n1 * 1 + n2 * 2 = n - 1;  n = n0 + n1 + n2;
 * 		换算 n0 * 0 + n1 * 1 + n2 * 2 =  n0 + n1 + n2 - 1; 得 : n0 = n2 + 1;
 * 14. 真二叉树: 所有节点的度都是 0 或者 2;
 * 15. 满二叉树: 所有叶子节点都在最后一层的真二叉树; (满二叉树一定是真二叉树, 真二叉树不一定是满二叉树);
 * 16. 满二叉的叶子节点个数为 an = 2 ⁽ⁿ⁻ ¹⁾,  节点数为  Sn = 2ⁿ - 1,  数的高度 n = log₂(Sn + 1);
 * 17. 完全二叉树: 叶子节点只出现在最后两层, 而且最后一层的叶子节点都是左对齐的.  完全二叉树从根节点到倒数第二层, 是一棵满二叉树; (满二叉树一定是完全二叉树, 完全二叉树不一定是满二叉树)
 * 		左对齐是
 *		度为一的节点只有左子树
 *		度为一的节点, 要么是1个, 要么是0个;
 *		完全二叉树 最少(最后一层一直有一个叶子节点)有 2⁽ⁿ⁻ ¹⁾( 即: 2⁰ + 2¹ + 2² + 2³ + ... 2⁽ⁿ⁻²⁾ + 1, 等比数列前n-2项求和 结果为 2 ⁽ⁿ⁻ ¹⁾)个节点, 最多(满二叉树)有 2ⁿ - 1个节点;
 */  