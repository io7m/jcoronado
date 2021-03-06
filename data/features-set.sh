#!/bin/sh

IFS="
"

for line in $(cat features.txt)
do
  NAME=$(echo $line | awk -F: '{print $1}')
  DESC=$(echo $line | sed 's/^[a-zA-Z0-9_]+ : //g')

  cat <<EOF
  .set${NAME^}(vk_features.${NAME}())
EOF
done
