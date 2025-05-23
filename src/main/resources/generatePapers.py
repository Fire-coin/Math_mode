base = "research_paper_tier_"
for i in range(6):
    with open(f"assets/mathmode/models/item/{base}{i}.json", 'w') as file:
        file.write(f"""{'{'}
    "parent": "item/generated",
    "textures": {'{'}
        "layer0": "mathmode:item/{base}{i}"
    {'}'}
{'}'}""")