package br.com.pcps.equipamento.equipamento.infra.jpa.repository;


public class EquipamentosQueryBusca {

        private static final String WHERE =
                " from \"Equipamentos\" t" +
                " where (NULLIF(:id,0) IS NULL OR :id = t.\"Index_Equip\")" +
                " and (:nome IS NULL OR UPPER(t.\"PN_Equip\") LIKE UPPER(CONCAT(CONCAT('%', :nome), '%')))";

        public static final String SELECT = "select t.* "+ WHERE;

        public static final String COUNT =  "select COUNT(1)"+ WHERE;

}