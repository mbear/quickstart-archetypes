muzongyan-quickstart-archetypes
=========================

This repository contains commonly used Maven Archetype Templates.

Installation:
-------------
1. Check out the templates
2. From command line goto project root folder. For ex: D:/workspace/muzongyan-quickstart-archetypes/quickstart-springmvc-mybatis
3. Execute the following maven commands to install maven archetype:

    quickstart-springmvc-mybatis> mvn clean

    quickstart-springmvc-mybatis> mvn archetype:create-from-project

    quickstart-springmvc-mybatis> cd target/generated-sources/archetype

    quickstart-springmvc-mybatis/target/generated-sources/archetype> mvn clean install


4. Repeat the same steps for all the archetype templates.
5. From Your IDE, while creating maven project filter the archetypes using 'com.muzongyan' and choose the template you want.
6. Enjoy :-)
