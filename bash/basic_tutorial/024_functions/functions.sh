#!/bin/bash
GLOBAL_VARIABLE="GLOBAL"
LOCAL_VARIABLE="LOCAL"

function updateGlobalWithOverride() {
    echo "Before changes \$GLOBAL_VARIABLE: $GLOBAL_VARIABLE "
    GLOBAL_VARIABLE=$1
    echo "After changes \$GLOBAL_VARIABLE: $GLOBAL_VARIABLE "
    return 0;
}

function updateLocalWithoutOverride() {
    echo "Before changes \$LOCAL_VARIABLE: $LOCAL_VARIABLE "
    local LOCAL_VARIABLE=$1
    echo "After changes \$LOCAL_VARIABLE: $LOCAL_VARIABLE "
    return 0;
}

echo "Before method call \$GLOBAL_VARIABLE: $GLOBAL_VARIABLE "
updateGlobalWithOverride "$GLOBAL_VARIABLE UPDATED"
echo "After method call \$GLOBAL_VARIABLE: $GLOBAL_VARIABLE "

echo "==================================================="

echo "Before method call \$LOCAL_VARIABLE: $LOCAL_VARIABLE "
updateLocalWithoutOverride "$LOCAL_VARIABLE UPDATED"
echo "After method call \$LOCAL_VARIABLE: $LOCAL_VARIABLE "