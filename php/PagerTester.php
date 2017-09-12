<?php

require_once __DIR__ . '/Pager.php';

function toPrint($list) {
    $strs = array();
    $current = 0;
    foreach ($list as $page) {
        $str = $page['number'];
        if ($page['isCurrent']) {
            $str = $str .  '↑';
            $current = $page['number'];
        }
        $strs[] = $str;
    }
    echo "(". $current . ")\t".implode("\t", $strs) . "\n";
}

if (1) {
    echo "--- 小于size ---\n";
    $total = 5;
    for ($i = 1; $i < $total; $i ++) {
        toPrint(Pager::pager($i, $total));
    }
}
if (1) {
    echo "--- 等于size ---\n";
    $size = 6;
    $total = 6;
    for ($i = 1; $i <= $total; $i ++) {
        toPrint(Pager::pager($i, $total, $size));
    }
}
if (1) {
    echo "--- size < total ---\n";
    $size = 3;
    $total = 6;
    for ($i = 1; $i <= $total; $i ++) {
        toPrint(Pager::pager($i, $total, $size));
    }
}
if (1) {
    echo "--- 大于size ---\n";
    $size = 11;
    $total = 20;
    for ($i = 1; $i <= $total; $i ++) {
        toPrint(Pager::pager($i, $total, $size));
    }
}

