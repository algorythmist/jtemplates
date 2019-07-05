# jtemplates
Implementation agnostic templating tool

If you are like me, you sometimes have to use one templating engine or another such as freemarker or mustache, but you forget the boilerplate code to set it up. Every time I need to use a templating engine, I have to google some examples.

This library takes care of this problem by introducing a single interface for accessing several templating engines. It helps you avoid implementation specific boileplate, and makes it easier to transition to a different templating engine down the line.

### Supported Templates
 - Velocity
 - Freemarker
 - Mustache
 - Rythm
 