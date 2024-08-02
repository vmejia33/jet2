/*
 * Copyright 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.jetlagged.data

import java.time.LocalTime

data class HeartRateData(val date: LocalTime, val amount: Int)
internal val heartRateGraphData = listOf(
    HeartRateData(LocalTime.of(0, 34), 55),
    HeartRateData(LocalTime.of(0, 52), 145),
    HeartRateData(LocalTime.of(0, 40), 99),
    HeartRateData(LocalTime.of(0, 19), 72),
    HeartRateData(LocalTime.of(0, 14), 150),
    HeartRateData(LocalTime.of(1, 44), 95),
    HeartRateData(LocalTime.of(1, 58), 105),
    HeartRateData(LocalTime.of(1, 21), 170),
    HeartRateData(LocalTime.of(1, 49), 152),
    HeartRateData(LocalTime.of(1, 31), 55),
    HeartRateData(LocalTime.of(1, 20), 158),
    HeartRateData(LocalTime.of(1, 41), 67),
    HeartRateData(LocalTime.of(1, 21), 65),
    HeartRateData(LocalTime.of(2, 4), 159),
    HeartRateData(LocalTime.of(2, 19), 174),
    HeartRateData(LocalTime.of(2, 19), 117),
    HeartRateData(LocalTime.of(2, 0), 84),
    HeartRateData(LocalTime.of(2, 33), 152),
    HeartRateData(LocalTime.of(2, 4), 162),
    HeartRateData(LocalTime.of(3, 11), 55),
    HeartRateData(LocalTime.of(3, 22), 93),
    HeartRateData(LocalTime.of(3, 39), 133),
    HeartRateData(LocalTime.of(3, 15), 173),
    HeartRateData(LocalTime.of(3, 7), 172),
    HeartRateData(LocalTime.of(4, 8), 93),
    HeartRateData(LocalTime.of(4, 27), 148),
    HeartRateData(LocalTime.of(4, 8), 153),
    HeartRateData(LocalTime.of(4, 47), 170),
    HeartRateData(LocalTime.of(4, 11), 60),
    HeartRateData(LocalTime.of(4, 46), 100),
    HeartRateData(LocalTime.of(4, 15), 175),
    HeartRateData(LocalTime.of(5, 39), 133),
    HeartRateData(LocalTime.of(5, 16), 98),
    HeartRateData(LocalTime.of(5, 59), 80),
    HeartRateData(LocalTime.of(5, 17), 122),
    HeartRateData(LocalTime.of(5, 55), 144),
    HeartRateData(LocalTime.of(5, 5), 101),
    HeartRateData(LocalTime.of(5, 3), 141),
    HeartRateData(LocalTime.of(5, 10), 153),
    HeartRateData(LocalTime.of(5, 17), 135),
    HeartRateData(LocalTime.of(6, 28), 117),
    HeartRateData(LocalTime.of(6, 22), 153),
    HeartRateData(LocalTime.of(6, 38), 103),
    HeartRateData(LocalTime.of(9, 6), 92),
    HeartRateData(LocalTime.of(9, 15), 141),
    HeartRateData(LocalTime.of(9, 22), 120),
    HeartRateData(LocalTime.of(10, 50), 125),
    HeartRateData(LocalTime.of(10, 4), 109),
    HeartRateData(LocalTime.of(10, 59), 174),
    HeartRateData(LocalTime.of(10, 11), 115),
    HeartRateData(LocalTime.of(10, 13), 92),
    HeartRateData(LocalTime.of(10, 4), 127),
    HeartRateData(LocalTime.of(10, 8), 62),
    HeartRateData(LocalTime.of(10, 9), 129),
    HeartRateData(LocalTime.of(11, 7), 128),
    HeartRateData(LocalTime.of(11, 44), 67),
    HeartRateData(LocalTime.of(11, 10), 130),
    HeartRateData(LocalTime.of(11, 12), 153),
    HeartRateData(LocalTime.of(11, 5), 133),
    HeartRateData(LocalTime.of(11, 31), 174),
    HeartRateData(LocalTime.of(11, 45), 91),
    HeartRateData(LocalTime.of(11, 9), 95),
    HeartRateData(LocalTime.of(11, 4), 102),
    HeartRateData(LocalTime.of(11, 46), 147),
    HeartRateData(LocalTime.of(11, 48), 145),
    HeartRateData(LocalTime.of(11, 44), 131),
    HeartRateData(LocalTime.of(12, 40), 159),
    HeartRateData(LocalTime.of(12, 14), 150),
    HeartRateData(LocalTime.of(12, 37), 118),
    HeartRateData(LocalTime.of(12, 38), 134),
    HeartRateData(LocalTime.of(12, 53), 168),
    HeartRateData(LocalTime.of(12, 11), 143),
    HeartRateData(LocalTime.of(12, 47), 110),
    HeartRateData(LocalTime.of(12, 21), 116),
    HeartRateData(LocalTime.of(12, 13), 145),
    HeartRateData(LocalTime.of(13, 37), 56),
    HeartRateData(LocalTime.of(13, 9), 132),
    HeartRateData(LocalTime.of(13, 6), 98),
    HeartRateData(LocalTime.of(13, 22), 134),
    HeartRateData(LocalTime.of(13, 25), 125),
    HeartRateData(LocalTime.of(13, 47), 101),
    HeartRateData(LocalTime.of(13, 50), 138),
    HeartRateData(LocalTime.of(13, 47), 59),
    HeartRateData(LocalTime.of(13, 55), 105),
    HeartRateData(LocalTime.of(14, 56), 73),
    HeartRateData(LocalTime.of(14, 7), 67),
    HeartRateData(LocalTime.of(14, 33), 118),
    HeartRateData(LocalTime.of(14, 50), 169),
    HeartRateData(LocalTime.of(14, 2), 125),
    HeartRateData(LocalTime.of(14, 16), 93),
    HeartRateData(LocalTime.of(14, 7), 80),
    HeartRateData(LocalTime.of(14, 1), 129),
    HeartRateData(LocalTime.of(14, 59), 142),
    HeartRateData(LocalTime.of(15, 5), 62),
    HeartRateData(LocalTime.of(15, 55), 132),
    HeartRateData(LocalTime.of(15, 41), 145),
    HeartRateData(LocalTime.of(15, 41), 107),
    HeartRateData(LocalTime.of(15, 45), 110),
    HeartRateData(LocalTime.of(16, 52), 97),
    HeartRateData(LocalTime.of(16, 16), 127),
    HeartRateData(LocalTime.of(16, 0), 155),
    HeartRateData(LocalTime.of(16, 35), 75),
    HeartRateData(LocalTime.of(16, 18), 170),
    HeartRateData(LocalTime.of(16, 6), 68),
    HeartRateData(LocalTime.of(16, 12), 63),
    HeartRateData(LocalTime.of(16, 2), 162),
    HeartRateData(LocalTime.of(16, 40), 146),
    HeartRateData(LocalTime.of(16, 26), 70),
    HeartRateData(LocalTime.of(16, 32), 121),
    HeartRateData(LocalTime.of(17, 49), 87),
    HeartRateData(LocalTime.of(17, 42), 54),
    HeartRateData(LocalTime.of(17, 12), 169),
    HeartRateData(LocalTime.of(17, 24), 154),
    HeartRateData(LocalTime.of(17, 4), 75),
    HeartRateData(LocalTime.of(17, 51), 104),
    HeartRateData(LocalTime.of(17, 53), 114),
    HeartRateData(LocalTime.of(17, 14), 93),
    HeartRateData(LocalTime.of(17, 35), 146),
    HeartRateData(LocalTime.of(17, 19), 101),
    HeartRateData(LocalTime.of(17, 27), 130),
    HeartRateData(LocalTime.of(17, 2), 56),
    HeartRateData(LocalTime.of(17, 27), 55),
    HeartRateData(LocalTime.of(17, 31), 73),
    HeartRateData(LocalTime.of(18, 59), 103),
    HeartRateData(LocalTime.of(18, 10), 95),
    HeartRateData(LocalTime.of(18, 28), 120),
    HeartRateData(LocalTime.of(18, 5), 88),
    HeartRateData(LocalTime.of(18, 44), 63),
    HeartRateData(LocalTime.of(18, 16), 124),
    HeartRateData(LocalTime.of(18, 14), 120),
    HeartRateData(LocalTime.of(18, 18), 121),
    HeartRateData(LocalTime.of(18, 53), 167),
    HeartRateData(LocalTime.of(18, 45), 110),
    HeartRateData(LocalTime.of(19, 19), 170),
    HeartRateData(LocalTime.of(19, 59), 85),
    HeartRateData(LocalTime.of(19, 4), 84),
    HeartRateData(LocalTime.of(19, 8), 111),
    HeartRateData(LocalTime.of(19, 54), 75),
    HeartRateData(LocalTime.of(20, 36), 122),
    HeartRateData(LocalTime.of(20, 21), 153),
    HeartRateData(LocalTime.of(20, 11), 82),
    HeartRateData(LocalTime.of(20, 19), 152),
    HeartRateData(LocalTime.of(20, 26), 56),
    HeartRateData(LocalTime.of(20, 21), 63),
    HeartRateData(LocalTime.of(20, 22), 90),
    HeartRateData(LocalTime.of(20, 20), 172),
    HeartRateData(LocalTime.of(20, 56), 78),
    HeartRateData(LocalTime.of(21, 52), 65),
    HeartRateData(LocalTime.of(21, 46), 106),
    HeartRateData(LocalTime.of(21, 57), 129),
    HeartRateData(LocalTime.of(21, 31), 105),
    HeartRateData(LocalTime.of(21, 39), 138),
    HeartRateData(LocalTime.of(21, 0), 93),
    HeartRateData(LocalTime.of(21, 20), 67),
    HeartRateData(LocalTime.of(21, 47), 166),
    HeartRateData(LocalTime.of(21, 10), 136),
    HeartRateData(LocalTime.of(21, 26), 90),
    HeartRateData(LocalTime.of(21, 56), 83),
    HeartRateData(LocalTime.of(21, 9), 72),
    HeartRateData(LocalTime.of(21, 38), 87),
    HeartRateData(LocalTime.of(22, 15), 149),
    HeartRateData(LocalTime.of(22, 25), 176),
    HeartRateData(LocalTime.of(22, 13), 77),
    HeartRateData(LocalTime.of(22, 53), 159),
    HeartRateData(LocalTime.of(22, 20), 81),
    HeartRateData(LocalTime.of(22, 48), 150),
    HeartRateData(LocalTime.of(22, 1), 123),
    HeartRateData(LocalTime.of(22, 19), 130),
    HeartRateData(LocalTime.of(23, 27), 147),
    HeartRateData(LocalTime.of(23, 59), 126),
    HeartRateData(LocalTime.of(23, 22), 142),
    HeartRateData(LocalTime.of(23, 48), 114),
    HeartRateData(LocalTime.of(23, 51), 93),
    HeartRateData(LocalTime.of(23, 46), 65),
    HeartRateData(LocalTime.of(23, 21), 63),
    HeartRateData(LocalTime.of(23, 59), 95),
).sortedBy { it.date.toSecondOfDay() }

const val numberEntries = 48 // 48 blocks of 30 minutes
const val bracketInSeconds = 30 * 60 // 30 minutes time frame
