package com.qinshou.qinshoubox.me.enums;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/10/9 16:17
 * Description:Npc 类枚举
 */
public enum Npc implements Type {
    /**
     * 序章(第 0 层)中的仙子
     */
    FAIRY_1,
    /**
     * 序章(第 0 层)中的仙子
     */
    FAIRY_2,
    /**
     * 上楼
     */
    GO_UPSTAIRS,
    /**
     * 下楼
     */
    GO_DOWNSTAIRS,
    /**
     * 黄色门
     */
    GATE_YELLOW,
    /**
     * 蓝色门
     */
    GATE_BLUE,
    /**
     * 红色门
     */
    GATE_RED,
    /**
     * 绿色门(第 2 层)
     */
    GATE_GREEN,
    /**
     * 可以打开的铁门,一碰即开
     */
    GATE_IRON_OPEN,
    /**
     * 不可以打开的铁门或需要满足某个条件才能打开的铁门
     */
    GATE_IRON_CLOSE,
    /**
     * 第 2 层的神秘老人,对话获得钢剑,攻击 +30
     */
    SHEN_MI_LAO_REN_FLOOR_2,
    /**
     * 第 2 层的商人,对话获得钢盾,防御+30
     */
    SHANG_REN_FLOOR_2,
    SHANG_DIAN_LAO_BAN_SMALL_1,
    /**
     * 第 3 层的商店老板,可以花费 25 金币购买 800 生命或 4 攻击或 4 防御
     */
    SHANG_DIAN_LAO_BAN_SMALL_2,
    SHANG_DIAN_LAO_BAN_SMALL_3,
    /**
     * 第 4 层的小偷,对话可打开第 2 层的绿色门
     */
    THIEF_1,
    /**
     * 第 4 层的小偷,获得第 12 层的嵌了红宝石的铁榔头后可打通第 18 层的路
     */
    THIEF_2,
    /**
     * 第 5 层的神秘老人,可以花费 100 经验升 1 级或 30 经验 +5 攻击或 30 经验 +5 防御
     */
    SHEN_MI_LAO_REN_FLOOR_5,
    /**
     * 第 5 层的商人,可以花费 10 金币购买 1 把黄钥匙或 50 金币购买 1 把蓝钥匙或 100 金币购买 1 把红钥匙
     */
    SHANG_REN_FLOOR_5,
    SHANG_DIAN_LAO_BAN_BIG_1,
    /**
     * 第 11 层的商店老板,可以花费 100 金币购买 4000 生命或 20 攻击或 20 防御
     */
    SHANG_DIAN_LAO_BAN_BIG_2,
    SHANG_DIAN_LAO_BAN_BIG_3,
    /**
     * 第 12 层的商人,可以卖出 1 把黄钥匙获取 7 金币或卖出 1 把蓝钥匙获得 35 金币或卖出 1 把红钥匙获得 70 金币
     */
    SHANG_REN_FLOOR_12,
    /**
     * 第 13 层的神秘老人,可以花费 270 经验升 3 级或 95 经验 +17 攻击或 95 经验 +17 防御
     */
    SHEN_MI_LAO_REN_FLOOR_13,
    /**
     * 第 15 层的神秘老人,花费 500 经验换取圣光剑
     */
    SHANG_REN_FLOOR_15,
    /**
     * 第 15 层的商人,花费 500 金币换取星光盾
     */
    SHEN_MI_LAO_REN_FLOOR_15,
    /**
     * 第 18 层的公主
     */
    PRINCESS
}