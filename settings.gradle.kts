rootProject.name = "tasklist"

include(
    "tasklist",
    ":web:user",
    "data",
    "infrastructure"
)
