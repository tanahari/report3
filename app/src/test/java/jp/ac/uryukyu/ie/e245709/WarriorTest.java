package jp.ac.uryukyu.ie.e245709;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {
    @Test
    void attackWithWeponSkill() {
        int defaultSlimeHp = 600;
        int defaultHeroAttack = 100;
        Warrior demoWarrior = new Warrior("デモ戦士", 100, defaultHeroAttack);
        Enemy slime = new Enemy("スライムもどき", defaultSlimeHp, 1);
        int i = 0;
        int skilldamage = (int)(defaultHeroAttack * 1.5);

        /** 
         * attackWithWeponSkillは毎回attackの150%を固定ダメージとして与えるかどうかを検証
         * 検証手順
         *  (1)戦士と敵を準備。スライムのHitPointは600とする。
         *     また戦士のattackは100とする。
         *  (2)戦士がスキルを使うと、150ダメージを与えることを期待。
         *  (3)固定ダメージを与えるならば与えたダメージの理論値と
         *     実際に与えられたダメージの量は毎回同じであるはず。
         *   　つまり戦士がスキルを使うと、slimeのHitPointが4回連続150ずつ減ることを期待する。
         */
        while (slime.isDead() == false) {
            i++;
            demoWarrior.attackWithWeponSkill(slime);
            int restHitPoint = defaultSlimeHp - skilldamage * i;
            assertEquals(restHitPoint, slime.getHitPoint());
        }
    }
}
