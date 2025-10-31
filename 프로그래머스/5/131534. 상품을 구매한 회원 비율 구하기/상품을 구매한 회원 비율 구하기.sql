WITH joined_2021 AS (
    -- 1) 2021년에 가입한 사람만 뽑아두는 CTE
    SELECT USER_ID
    FROM USER_INFO
    WHERE YEAR(JOINED) = 2021
),
month_purchase AS (
    -- 2) 그 사람들 중 실제로 2021년 이후에 구매한 기록을 월 단위로 집계
    SELECT
        YEAR(o.SALES_DATE)  AS YEAR,
        MONTH(o.SALES_DATE) AS MONTH,
        COUNT(DISTINCT o.USER_ID) AS PURCHASED_USERS
    FROM ONLINE_SALE o
    JOIN joined_2021 j ON o.USER_ID = j.USER_ID
    GROUP BY YEAR(o.SALES_DATE), MONTH(o.SALES_DATE)
)
SELECT
    m.YEAR,
    m.MONTH,
    m.PURCHASED_USERS,
    ROUND(
        m.PURCHASED_USERS * 1.0 / (SELECT COUNT(*) FROM joined_2021),
        1
    ) AS PURCHASED_RATIO
FROM month_purchase m
ORDER BY m.YEAR, m.MONTH;